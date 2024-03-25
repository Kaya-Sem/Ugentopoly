package be.ugent.objprog.ugentopoly.Parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import be.ugent.objprog.ugentopoly.TileNodes.Tile;

public class XMLParser {

    Document document;
    Element rootElement;

    /*
     * When initialized, the XMLParsers will just load and parse a document.
     * More specific return values and behaviour can be specified using its methods.
     */
    public XMLParser() {
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream inputStream = getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.xml");
        try {
            this.document = saxBuilder.build(inputStream);
        } catch (JDOMException | IOException e) {
            throw new RuntimeException(e);
        }

        this.rootElement = document.getRootElement();
    }

    // TODO make switch case a dict with a factory
    // TODO return proper list
    // load tile information

    // List<? extends Tile>
    public void parseTiles() {
        List<? extends Tile> tiles = new ArrayList<>();

        Element tilesElement = rootElement.getChild("tiles");
        List<Element> tileElements = tilesElement.getChildren("tile");

        for (Element tileElement : tileElements) {
            // Parse tile attributes and create Tile object

        }
    }
}
