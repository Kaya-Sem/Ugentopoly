package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.Factories.TileFactory;
import be.ugent.objprog.ugentopoly.Parsers.XMLParser;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    NON URGENT write out class documentation
*/

public class TileInitializer {

    public static Map<String, List<? extends Tile>> initialiseTiles() {

        // Retrieve a map of tiles with their data.
        XMLParser parser = new XMLParser();
        Map<String, Map<String, String>> tilesData = parser.parseTileData();

        // create factory and create all tiles
        TileFactory factory = new TileFactory();
        Tile[] tilesArray = new Tile[40];

        for (Map.Entry<String, Map<String, String>> entry : tilesData.entrySet()) {
            Map<String, String> tileProperties = entry.getValue();

            // Create tile using factory
            Tile tile = factory.forge(tileProperties);

            // get the correct tile index
            int index = Integer.parseInt(tileProperties.get("position"));

            tilesArray[index] = tile;
        }





        // voor elke entry, geef diens waarde door aan de factory.
        // de factory moet een
        // De factory moet een tile teruggeven.

        // HACK : do not do this manually -> use XMLParser
        /*
        List<? extends Tile> upperBarTiles = List.of(
                new StreetTile(90, "street", "#9932cc"),
                new UtilityTile(90),
                new StreetTile(90, "street", "#9932cc"),
                new StreetTile(90, "street", "#9932cc"),
                new RailwayTile(90, "button"),
                new StreetTile(90, "button", "#9932cc"),
                new StreetTile(90, "button", "#9932cc"),
                new StreetTile(90, "button", "#9932cc"),
                new StreetTile(90, "button", "#9932cc"));
        List<? extends Tile> bottomBarTiles = List.of(
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"),
                new StreetTile(270, "button", "#9932cc"));

        List<? extends Tile> leftBarTiles = List.of(
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"),
                new StreetTile(0, "button", "#9932cc"));
        List<? extends Tile> rightBarTiles = List.of(
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"),
                new StreetTile(180, "button", "#9932cc"));

         */

//        List<? extends Tile> cornerTiles = List.of(
//                new CornerTile(),
//                new CornerTile(),
//                new CornerTile(),
//                new CornerTile());
//
        Map<String, List<? extends Tile>> initializedTileMap = new HashMap<>();
//        initializedTileMap.put("top_row", upperBarTiles);
//        initializedTileMap.put("bottom_row", bottomBarTiles);
//        initializedTileMap.put("right_bar", rightBarTiles);
//        initializedTileMap.put("left_bar", leftBarTiles);
//        initializedTileMap.put("corners", cornerTiles);

        // TODO implement testing

        return initializedTileMap;

    }
}
