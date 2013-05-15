package fr.kissy.hellion.definition.encoder.main.parser;

import fr.kissy.hellion.definition.encoder.main.utils.AssertUtils;
import fr.kissy.hellion.definition.encoder.main.utils.ParseUtils;
import fr.kissy.hellion.proto.Common;
import org.apache.commons.beanutils.MethodUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.management.modelmbean.XMLParseException;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

/**
 * @author Guillaume Le Biller <lebiller@ekino.com>
 * @version $Id: ObjectParser.java 7 2012-03-02 17:43:54Z kissy $
 */
public class ObjectParser extends AbstractParser {

    /**
     * @inheritDoc
     */
    public ObjectParser(String xmlPath, String outputPath, Common.Object.Builder builder) throws XMLParseException {
        super(xmlPath, outputPath);
        this.builder = builder;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected void parse() {
        try {
            System.out.println("Parsing ODF File " + xmlFile.getPath());

            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile).getDocumentElement();
            documentElement.normalize();

            AssertUtils.makeTest("Object".equals(documentElement.getNodeName()), "ODF files must contain Object root element");

            NodeList nodeList = documentElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    MethodUtils.invokeExactMethod(this, "parse" + node.getNodeName(), new Object[]{node}, new Class[]{Element.class});
                }
            }

            System.out.println("ODF File parsed\n");
            parsed = true;
        } catch (Exception e) {
            throw new RuntimeException("Cannot parse the ODF File " + xmlFile.getPath() + ", " + e.getMessage());
        }
    }

    /**
     * Parse the resources.
     *
     * @param propertiesElement The Properties element.
     * @throws javax.management.modelmbean.XMLParseException Exception if the document is malformed.
     */
    private void parseProperties(Element propertiesElement) throws XMLParseException {
        System.out.println("\t- Parsing Properties");

        // Object properties
        getObjectBuilder().addSystemObjects(ParseUtils.parseObjectProperties(propertiesElement));
    }

    /**
     * Get the ODF Builder.
     *
     * @return The ODF Builder.
     */
    public Common.Object.Builder getObjectBuilder() {
        return (Common.Object.Builder) builder;
    }

    /**
     * @inheritDoc
     */
    @Override
    public File writeBuilder() throws IOException, XMLParseException {
        if (builder != null) {
            parse();
        }
        
        return null;
    }
}
