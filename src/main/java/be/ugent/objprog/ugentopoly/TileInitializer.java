package be.ugent.objprog.ugentopoly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.ugent.objprog.ugentopoly.Parsers.XMLParser;
import be.ugent.objprog.ugentopoly.TileNodes.CornerTile;
import be.ugent.objprog.ugentopoly.TileNodes.RailwayTile;
import be.ugent.objprog.ugentopoly.TileNodes.StreetTile;
import be.ugent.objprog.ugentopoly.TileNodes.Tile;
import be.ugent.objprog.ugentopoly.TileNodes.UtilityTile;

/*
NON_URGENT write out class documentation

 */

public class TileInitializer {

    public static Map<String, List<? extends Tile>> initialiseTiles() {

        XMLParser parser = new XMLParser();

        // TODO implement
        Map<String, Map<String, String>> map = parser.parseTilesData();

        // HACK : do not do this manually -> use XMLParser
        List<? extends Tile> upperBarTiles = List.of(
                new StreetTile(90, "street", "#9932cc"),
                new UtilityTile(90, "utility"),
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

        List<? extends Tile> cornerTiles = List.of(
                new CornerTile(),
                new CornerTile(),
                new CornerTile(),
                new CornerTile());

        Map<String, List<? extends Tile>> initializedTileMap = new HashMap<>();
        initializedTileMap.put("top_row", upperBarTiles);
        initializedTileMap.put("bottom_row", bottomBarTiles);
        initializedTileMap.put("right_bar", rightBarTiles);
        initializedTileMap.put("left_bar", leftBarTiles);
        initializedTileMap.put("corners", cornerTiles);


        return initializedTileMap;

    }
}
