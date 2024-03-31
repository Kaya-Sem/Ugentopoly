package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import be.ugent.objprog.ugentopoly.Parsers.XMLParser;
import be.ugent.objprog.ugentopoly.Tiles.Tile.*;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.*;

public class TempTileSetup {

    static XMLParser parser = new XMLParser();
    static Map<String, String> colors = parser.areaColors();

    public static StartTile templateCornerTile() {
        return new StartTile(
                new CornerCompanion(
                        "START",
                        "0",
                        "tile.street01"),
                "tile.jail");
    }

    public static ChestTile templateChestTile(){
        return new ChestTile(
                new ChestCompanion(
                        "CHEST",
                        "2",
                        "tile.chest"
                ),
                "tile.chest"
        );
    }

    public static ChanceTile templateChanceTile(){
        return new ChanceTile(
                new ChanceCompanion(
                        "CHANCE",
                        "7",
                        "tile.chance"
                ),
                "tile.chance"
        );
    }

    public static TaxTile templateTaxTile(){
        return new TaxTile(
                new TaxCompanion(
                        "TAX",
                        "4",
                        "tile.tax1",
                        "200"
                ),
                "tile.tax1"
        );
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
                "tile.street05",
                colors.get("area1")

                );
    }

    protected static RailwayTile templateRailwayTile(){
     return new RailwayTile(
             new RailwayCompanion(
                     "RAILWAY",
                     "5",
                     "tile.railway1",
                     "200",
                     "50"
             ),
             "tile.railway1"
     );
    }

    protected static UtilityTile templateUtilityTile(){
        return new UtilityTile(
                new UtilityCompanion(
                       "UTILITY",
                "12",
                        "tile.utility1",
                        "150"),
                "tile.utility2"
        );
    }

    protected static StartTile initStartTile(){
        return new StartTile(
                new CornerCompanion(
                        "START",
                        "0",
                        "tile.start"
                ),
                "tile.start"
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
            templateUtilityTile(),
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
            templateUtilityTile(),
            templateTile(),
            templateChanceTile(),
            templateTaxTile(),
            templateRailwayTile(),
            templateTile(),
            templateTile(),
            templateChestTile(),
            templateTile()));

    public static ArrayList<? extends Tile> cornerTiles = new ArrayList<>(Arrays.asList(
            initStartTile(),
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
