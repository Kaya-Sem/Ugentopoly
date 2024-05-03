package be.ugent.objprog.ugentopoly.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * The parsing is done at initialization, storing the root element of the XML for efficient data retrieval.
 * Design Justifications:
 * - The XML file is parsed only once when the XMLParser object is created, improving performance by avoiding
 *   repeated file reading and parsing operations.
 * - Use of the static array `ATTRIBUTES` allows dynamic parsing of known attributes, enhancing
 *   maintainability. If new attributes are added to the XML schema, only this array needs an update.
 */

public class XMLParser {
    private static final String XML_PATH = "/be/ugent/objprog/ugentopoly/ugentopoly.xml";
    private static final String[] ATTRIBUTES = {"area", "cost", "rent", "rent0", "amount", "position"};
    Document document = null;
    Element root = null;

    public XMLParser()  {
        InputStream inputStream = getClass().getResourceAsStream(XML_PATH);
        try {
            document = new SAXBuilder().build(inputStream);
            root = document.getRootElement();
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
    }

    public String getStartingBalance() {
        Element settings = root.getChild("settings");
        return settings.getAttributeValue("balance");
    }

    public Map<String, Map<String, String>> getChanceCards() {
        return getDeckCards("CHANCE");
    }

    public Map<String, Map<String, String>> getChestCards() {
        return getDeckCards("CHEST");
    }

    private Map<String, Map<String, String>> getDeckCards(String deckType) {
        Map<String, Map<String, String>> cards = new HashMap<>();
        List<Element> decks = root.getChildren("deck");
        List<Element> cardElements = new ArrayList<>();

        decks.stream().filter(deck -> deck.getAttributeValue("type").equals(deckType)).forEach(deck -> {
            cardElements.addAll(deck.getChildren("card"));
            cardElements.forEach(card -> {
                Map<String, String> cardAttributes = new HashMap<>();

                // Each tile has this in common
                String cardId = card.getAttributeValue("id");
                cardAttributes.put("id", cardId);
                cardAttributes.put("type", card.getAttributeValue("type"));

                card.getAttributes().forEach(attribute -> cardAttributes.put(attribute.getName(), attribute.getValue()));

                cards.put(cardId, cardAttributes);
            });
        });
        return cards;
    }

    public int getStartAmount() {
        Element settings = root.getChild("settings");
        return Integer.parseInt(settings.getAttributeValue("start"));
    }

    // load tileViews information
    public Map<String, Map<String, String>> parseAllTileData() {
        Map<String, Map<String, String>> tiles = new HashMap<>();

        List<Element> tileElements = root.getChildren("tiles").getFirst().getChildren("tile");

        if (tileElements.isEmpty()) {
            throw new IllegalStateException("tile data has not correctly been parsed from XML file. Nothing was returned");
        }

        // Parse tileViews attributes and create tileViews data map
        tileElements.forEach(tileElement -> {
            String tileIdentifier = tileElement.getAttributeValue("position");
            Map<String, String> tileAttributes = parseTile(tileElement);
            tiles.put(tileIdentifier, tileAttributes);
        });
        return tiles;
    }

    private static Map<String, String> parseTile(Element tileElement) {
        Map<String, String> tileMap = new HashMap<>();
        tileMap.put("id", tileElement.getAttributeValue("id"));
        tileMap.put("type", tileElement.getAttributeValue("type"));

        Arrays.stream(ATTRIBUTES).forEach(attr -> tileMap.put(attr, tileElement.getAttributeValue(attr)));

        tileMap.entrySet().removeIf(entry -> entry.getValue() == null);
        return tileMap;
    }

    public Map<String, String> areaColors() {
        Map<String, String> colors = new HashMap<>();
        List<Element> colorElements = root.getChildren("areas").getFirst().getChildren("area");

        colorElements.forEach(colorElement -> {
            String colorId = colorElement.getAttributeValue("id");
            String color = colorElement.getAttributeValue("color");
            colors.put(colorId, color);
        });
        return colors;
    }

}