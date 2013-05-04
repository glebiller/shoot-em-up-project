package fr.kissy.hellion.server.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import fr.kissy.hellion.proto.common.PropertyDto;
import fr.kissy.hellion.proto.message.ObjectUpdated;
import fr.kissy.hellion.proto.server.UpstreamMessageDto;
import fr.kissy.hellion.server.domain.Player;
import fr.kissy.hellion.server.handler.event.AuthenticatedMessageEvent;
import fr.kissy.hellion.server.service.WorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


/**
 * @author Guillaume Le Biller <lebiller@ekino.com>
 * @version $Id$
 */
public class PlayerMoveActor extends UntypedActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerMoveActor.class);

    @Autowired
    @Qualifier("synchronizeActorRef")
    private ActorRef synchronizeActorRef;

    @Override
    public void onReceive(Object o) throws Exception {
        AuthenticatedMessageEvent messageEvent = (AuthenticatedMessageEvent) o;
        LOGGER.debug("Received event {} for user {}", messageEvent.getMessage().getType(), messageEvent.getSubject().getPrincipal());

        ObjectUpdated.ObjectUpdatedProto updatedProto = ObjectUpdated.ObjectUpdatedProto.parseFrom(messageEvent.getMessage().getData());
        Player player = (Player) messageEvent.getSubject().getSession().getAttribute(Player.class.getSimpleName());
        for (PropertyDto.PropertyProto propertyProto : updatedProto.getObjects(0).getSystemObjects(0).getPropertiesList()) {
            if (propertyProto.getName().equals("Position")) {
                player.setPosition(
                    propertyProto.getValue(0),
                    propertyProto.getValue(1),
                    propertyProto.getValue(2)
                );
            } else if (propertyProto.getName().equals("Orientation")) {
                player.setOrientation(
                    propertyProto.getValue(0),
                    propertyProto.getValue(1),
                    propertyProto.getValue(2),
                    propertyProto.getValue(3)
                );
            } else if (propertyProto.getName().equals("Velocity")) {
                player.setVelocity(
                    propertyProto.getValue(0),
                    propertyProto.getValue(1),
                    propertyProto.getValue(2),
                    propertyProto.getValue(3)
                );
            }
        }

        synchronizeActorRef.tell(o, getSelf());
    }

}
