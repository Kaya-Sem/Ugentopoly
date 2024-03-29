package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTile;
import be.ugent.objprog.ugentopoly.Tiles.Tile.StreetTile;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.CornerCompanion;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.StreetCompanion;

public class TempTileSetup {

    public static CornerTile templateCornerTile() {
        return new CornerTile(
                new CornerCompanion(
                        "START",
                        "0",
                        "tile.street01"),
                "tile.street01");
    }

    protected static StreetTile templateTile() {
        return new StreetTile(
                new StreetCompanion(
                        "STREET",
                        "1",
                        "area1",
                        "tile.street01",
                        "60",
                        "2",
                        "10",
                        "30",
                        "90",
                        "160",
                        "250"),
                "tile.street05"
                );
    }

    public static ArrayList<? extends Tile> upperBarTiles = new ArrayList<>(Arrays.asList(
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile()));

    public static ArrayList<? extends Tile> bottomBarTiles = new ArrayList<>(Arrays.asList(
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile()));

    public static ArrayList<? extends Tile> rightBarTiles = new ArrayList<>(Arrays.asList(
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile()));

    public static ArrayList<? extends Tile> leftBarTiles = new ArrayList<>(Arrays.asList(
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile()));

    public static ArrayList<? extends Tile> cornerTiles = new ArrayList<>(Arrays.asList(
            templateCornerTile(),
            templateCornerTile(),
            templateCornerTile(),
            templateCornerTile()));

    public static Map<String, ArrayList<? extends Tile>> initializedTileMap = new HashMap<>() {
        {
            put("top_row", upperBarTiles);
            put("bottom_row", bottomBarTiles);
            put("right_bar", rightBarTiles);
            put("left_bar", leftBarTiles);
            put("corners", cornerTiles);
        }
    };
}
