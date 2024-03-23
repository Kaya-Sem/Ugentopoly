package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.Tiles.Tile;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    Document document;
    Element rootElement;
    List<? extends Tile> tiles;


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
    // load tile information
    public List<? extends Tile> parseTiles(){
         this.tiles =  new ArrayList<>();

         Element tilesElement = rootElement.getChild("tiles");
         List<Element> tileElements = tilesElement.getChildren("tile");

         for (Element tileElement : tileElements) {
             // Parse tile attributes and create Tile object

             switch (tileElement.getAttributeValue("type")) {
                 case "START" -> {}
                 case "STREET" -> {}
                 case "CHEST" -> {}
                 case "TAX" -> {}
                 case "RAILWAY" -> {}
                 case "CHANCE" -> {}
                 case "JAIL" -> {}
                 case "UTILITY" -> {}
                 case "FREE_PARKING" -> {}
                 case "GO_TO_JAIL" -> {}

             }

         }
    }
}
