package be.ugent.objprog.ugentopoly.parsers;

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
    /*
     * NON-URGENT: write out XMLParser documentation
     */

    // TODO parse make parsers for other xml data

    private static final String XML_PATH = "/be/ugent/objprog/ugentopoly/ugentopoly.xml";
    static final String[] ATTRIBUTES = { "area", "cost", "rent", "rent0", "rent1", "rent2", "rent3", "rent4", "rent5",
            "amount" };
    Document document;
    Element root;

    public XMLParser() {
        InputStream inputStream = getClass().getResourceAsStream(XML_PATH);
        try {
            this.document = new SAXBuilder().build(inputStream);
        } catch (JDOMException | IOException e) {
            throw new RuntimeException("Error occurred in creating document in XMLParser" + e);
        }

        this.root = document.getRootElement();
        // NEEDSLOG
    }

    public String getStartingBalance() {
        Element settings = root.getChild("settings");
        String balance = settings.getAttributeValue("balance");
        return balance;
    }

    // load tileViews information
    public Map<String, Map<String, String>> parseAllTileData() {
        Map<String, Map<String, String>> tiles = new HashMap<>();

        List<Element> tileElements = root.getChildren("tiles").getFirst().getChildren("tile");

        if (tileElements.isEmpty()) {
            throw new IllegalStateException("tile data has not correctly been parsed from XML file. Nothing was returned");
        }

        for (Element tileElement : tileElements) {
            // Parse tileViews attributes and create tileViews data map
            String tileIdentifier = tileElement.getAttributeValue("position");
            Map<String, String> tileAttributes = parseTile(tileElement);
            tiles.put(tileIdentifier, tileAttributes);
        }

        return tiles;
    }

    // NEED HELP linkedHashMap incorrect order even when XML is correct. 1 element
    // wrong
    private static Map<String, String> parseTile(Element tileElement) {
        Map<String, String> tileMap = new HashMap<>();
        tileMap.put("position", tileElement.getAttributeValue("position"));
        tileMap.put("id", tileElement.getAttributeValue("id"));
        tileMap.put("type", tileElement.getAttributeValue("type"));

        for (String attr : XMLParser.ATTRIBUTES) {
            tileMap.put(attr, tileElement.getAttributeValue(attr));
        }

        tileMap.entrySet().removeIf(entry -> entry.getValue() == null);

        return tileMap;
    }

    public Map<String, String> areaColors() {
        Map<String, String> colors = new HashMap<>();
        List<Element> colorElements = root.getChildren("areas").getFirst().getChildren("area");

        for (Element colorElement : colorElements) {
            String colorId = colorElement.getAttributeValue("id");
            String color = colorElement.getAttributeValue("color");
            colors.put(colorId, color);
        }

        if (colors.isEmpty()) {
            throw new IllegalStateException("\n area color map was empty unexpectedly...\n");
        }

        return colors;
    }

    private static void test() {
        XMLParser parser = new XMLParser();
        Map<String, Map<String, String>> tilesData = parser.parseAllTileData();

        System.out.println(tilesData.size());

        for (Map.Entry<?, ?> entry : tilesData.entrySet()) {
            System.out.printf("%-15s : %s%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Starting balance: " + parser.getStartingBalance());

        System.out.println(parser.areaColors());
    }

    public static void main(String[] args) {
        test();
    }
}