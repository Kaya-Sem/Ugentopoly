package be.ugent.objprog.ugentopoly.Parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLParser {

    Document document;
    Element root;
    private static final String XML_PATH = "/be/ugent/objprog/ugentopoly/ugentopoly.xml";

    /*
     * When initialized, the XMLParsers will only load and prepare a document.
     * More specific return values and behaviour can be retrieved using its methods.
     * NON URGENT: write out XMLParser documentation
     */
    public XMLParser() {
        InputStream inputStream = getClass().getResourceAsStream(XML_PATH);
        try {
            this.document = new SAXBuilder().build(inputStream);
        } catch (JDOMException | IOException e) {
            throw new RuntimeException(e);
        }

        this.root = document.getRootElement();
    }

    // TODO parse make parsers for other xml data .

    // load tile information
    public Map<String, Map<String, String>> parseTileData() {
        Map<String, Map<String, String>> tiles = new HashMap<>();

        List<Element> tileElements = root.getChildren("tiles").getFirst().getChildren("tile");

        for (Element tileElement : tileElements) {
            // Parse tile attributes and create Tile object
            String tileId = tileElement.getAttributeValue("id");
            Map<String, String> tileAttributes = parseTile(tileElement);
            tiles.put(tileId, tileAttributes);
        }

        return tiles;
    }

    private static Map<String, String> parseTile(Element tileElement) {
        Map<String, String> tileMap = new HashMap<>();
        tileMap.put("type", tileElement.getAttributeValue("type"));
        tileMap.put("position", tileElement.getAttributeValue("position"));
        tileMap.put("id", tileElement.getAttributeValue("id"));

        // Get other attributes, filling with null if not present
        String[] possibleAttributes = {
                "area", "cost", "rent0", "rent1", "rent2", "rent3", "rent4", "rent5", "amount",
                "collect"
        };
        for (String attr : possibleAttributes) {
            tileMap.put(attr, tileElement.getAttributeValue(attr));
        }

        return tileMap;
    }

    private static void test() {
        XMLParser parser = new XMLParser();
        Map<String, Map<String, String>> tilesData = parser.parseTileData();
        for (Map.Entry<?, ?> entry : tilesData.entrySet()) {
            System.out.printf("%-15s : %s%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        test();
    }
}
