package be.ugent.objprog.ugentopoly.parsers;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLParser {
    /*
     * NON-URGENT: write out XMLParser documentation
     */

    // TODO parse make parsers for other xml data

    private static final String XML_PATH = "/be/ugent/objprog/ugentopoly/ugentopoly.xml";
    static final String[] ATTRIBUTES = {"area", "cost", "rent0", "rent1", "rent2", "rent3", "rent4", "rent5", "amount"};
    Document document;
    Element root;

    public XMLParser() {
        InputStream inputStream = getClass().getResourceAsStream(XML_PATH);
        try {
            this.document = new SAXBuilder().build(inputStream);
        } catch (JDOMException | IOException e) {
            throw new RuntimeException(e);
        }

        this.root = document.getRootElement();
    }

    public Map<String, String> areaColors(){
        Map<String, String> colors = new HashMap<>();
        List<Element> colorElements = root.getChildren("areas").getFirst().getChildren("area");

        for (Element colorElement : colorElements) {
            String colorId = colorElement.getAttributeValue("id");
            String color = colorElement.getAttributeValue("color");
            colors.put(colorId, color);
        }

        return colors;
    }



    // NEED HELP linkedHashMap incorrect order even when XML is correct. 1 element wrong
    private static Map<String, String> parseTile(Element tileElement) {
        Map<String, String> tileMap = new HashMap<>();
        tileMap.put("type", tileElement.getAttributeValue("type"));
        tileMap.put("position", tileElement.getAttributeValue("position"));
        tileMap.put("id", tileElement.getAttributeValue("id"));

        for (String attr : XMLParser.ATTRIBUTES) {
            tileMap.put(attr, tileElement.getAttributeValue(attr));
        }

        return tileMap;
    }

    // NON URGENT maak een testklasse aan hiervoor? hoe specifieer ik correcte
    // return value?
    // maak ook voor andere testklassen aan
    private static void test() {
        XMLParser parser = new XMLParser();
        Map<String, Map<String, String>> tilesData = parser.parseTileData();
        for (Map.Entry<?, ?> entry : tilesData.entrySet()) {
            System.out.printf("%-15s : %s%n", entry.getKey(), entry.getValue());
        }

        System.out.println();

        System.out.println(parser.areaColors());
    }

    public static void main(String[] args) {
        test();
    }

    // load tile information
    public Map<String, Map<String, String>> parseTileData() {
        Map<String, Map<String, String>> tiles = new HashMap<>();

        List<Element> tileElements = root.getChildren("tiles").getFirst().getChildren("tile");

        for (Element tileElement : tileElements) {
            // Parse tile attributes and create tile object
            String tileId = tileElement.getAttributeValue("id");
            Map<String, String> tileAttributes = parseTile(tileElement);
            tiles.put(tileId, tileAttributes);
        }

        return tiles;
    }
}