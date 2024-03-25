package be.ugent.objprog.ugentopoly.Parsers;

import be.ugent.objprog.ugentopoly.Factories.StreetTileObjectFactory;
import be.ugent.objprog.ugentopoly.TileNodes.Tile;
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


    /* When initialized, the XMLParsers will just load and parse a document.
        More specific return values and behaviour can be specified using its methods.
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
    public void parseTiles(){
         this.tiles =  new ArrayList<>();

         StreetTileObjectFactory streetTileObjectFactory = new StreetTileObjectFactory();

         Element tilesElement = rootElement.getChild("tiles");
         List<Element> tileElements = tilesElement.getChildren("tile");

         for (Element tileElement : tileElements) {
             // Parse tile attributes and create Tile object

             switch (tileElement.getAttributeValue("type")) {
                 case "START" -> {}
                 /*case "STREET" -> {
                     streetTileObjectFactory.forge(
                             "4",
                             "F",
                             "id",
                             "rent0",
                             "rent1",
                             "rent3",
                             "rent 5",
                             "f",
                             "f"
                     );
                 }*/
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
