package fr.kissy.hellion.server.actor;

import akka.actor.UntypedActor;
import com.google.common.collect.Sets;
import fr.kissy.hellion.proto.common.ObjectDto;
import fr.kissy.hellion.proto.common.SystemDto;
import fr.kissy.hellion.proto.message.ObjectUpdated;
import fr.kissy.hellion.proto.server.UpstreamMessageDto;
import fr.kissy.hellion.server.domain.Player;
import fr.kissy.hellion.server.handler.event.AuthenticatedMessageEvent;
import fr.kissy.hellion.server.service.UpstreamMessageService;
import fr.kissy.hellion.server.service.WorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


/**
 * Send the list of near players to be created & deleted.
 *
 * @author Guillaume Le Biller <lebiller@ekino.com>
 * @version $Id$
 */
public class SynchronizeActor extends UntypedActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizeActor.class);

    @Autowired
    private WorldService worldService;
    @Autowired
    private UpstreamMessageService upstreamMessageService;

    @Override
    public void onReceive(Object o) throws Exception {
        AuthenticatedMessageEvent messageEvent = (AuthenticatedMessageEvent) o;
        LOGGER.debug("Received event {} for user {}", messageEvent.getMessage().getType(), messageEvent.getSubject().getPrincipal());

        Player player = (Player) messageEvent.getSubject().getSession().getAttribute(Player.class.getSimpleName());
        List<Player> nearPlayers = worldService.getNearPlayers(player); // TODO return Set instead ?

        Set<Player> createdPlayers = Sets.newHashSet();
        Set<Player> updatedPlayers = Sets.newHashSet();

        LOGGER.debug("Number of near players for user {} is {}", player.getId(), nearPlayers.size());
        for (Player nearPlayer : nearPlayers) {
            // If the player doesn't have it already in it's list
            // then add the object to creation set.
            if (player.getNearPlayers().add(nearPlayer)) {
                createdPlayers.add(nearPlayer);
            } else {
                updatedPlayers.add(nearPlayer);
            }
        }

        Set<Player> deletedPlayers = Sets.difference(player.getNearPlayers(), Sets.newHashSet(nearPlayers));

        // Current player can have either created or deleted object
        LOGGER.debug("Number of player to create for user {} is {}", player.getId(), createdPlayers.size());
        if (createdPlayers.size() > 0) {
            player.getChannel().write(upstreamMessageService.getObjectCreatedMessage(createdPlayers));
            UpstreamMessageDto.UpstreamMessageProto playerCreateMessage = upstreamMessageService.getObjectCreatedMessage(player);
            for (Player nearPlayer : createdPlayers) {
                nearPlayer.getNearPlayers().add(player);
                nearPlayer.getChannel().write(playerCreateMessage);
            }
        }
        LOGGER.debug("Number of player to update for user {} is {}", player.getId(), updatedPlayers.size());
        if (updatedPlayers.size() > 0) {
            // Do not send the update to the current player
            UpstreamMessageDto.UpstreamMessageProto playerUpdateMessage = upstreamMessageService.getObjectUpdatedMessage(player);
            for (Player nearPlayer : updatedPlayers) {
                nearPlayer.getChannel().write(playerUpdateMessage);
            }
        }
        LOGGER.debug("Number of player to delete for user {} is {}", player.getId(), deletedPlayers.size());
        if (deletedPlayers.size() > 0) {
            player.getChannel().write(upstreamMessageService.getObjectDeletedMessage(deletedPlayers));
            UpstreamMessageDto.UpstreamMessageProto playerDeleteMessage = upstreamMessageService.getObjectDeletedMessage(player);
            for (Player nearPlayer : deletedPlayers) {
                player.getNearPlayers().remove(nearPlayer);
                nearPlayer.getNearPlayers().remove(player);
                nearPlayer.getChannel().write(playerDeleteMessage);
            }
        }
    }
}
