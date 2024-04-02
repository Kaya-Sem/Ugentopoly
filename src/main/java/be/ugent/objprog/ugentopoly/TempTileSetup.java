package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import be.ugent.objprog.ugentopoly.Parsers.XMLParser;
import be.ugent.objprog.ugentopoly.Tiles.Tile.*;
import be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles.FreeParkingCornerTile;
import be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles.GoToJailCornerTile;
import be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles.JailCornerTile;
import be.ugent.objprog.ugentopoly.Tiles.Tile.CornerTiles.StartCornerTile;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.*;

public class TempTileSetup {

    static XMLParser parser = new XMLParser();
    static Map<String, String> colors = parser.areaColors();

    public static JailCornerTile initJailCornerTile() {
        return new JailCornerTile(
                new CornerCompanion(
                        "JAIL",
                        "10",
                        "tile.jail"
                ),
                "tile.jail"
        );
    }

    public static ChestTile initChestTile(){
        return new ChestTile(
                new ChestCompanion(
                        "CHEST",
                        "2",
                        "tile.chest"
                ),
                "tile.chest"
        );
    }

    public static ChanceTile initChanceTile(){
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

    protected static StartCornerTile initStartTile(){
        return new StartCornerTile(
                new CornerCompanion(
                        "START",
                        "0",
                        "tile.start"
                ),
                "tile.start"
        );
    }

    public static FreeParkingCornerTile initFreeParkingCornerTile(){
        return new FreeParkingCornerTile(
                new CornerCompanion(
                        "FREE_PARKING",
                        "20",
                        "tile.freeparking"
                ),
                "tile.freeparking"
        );
    }

    public static GoToJailCornerTile initGoToJailCornerTile(){
        return new GoToJailCornerTile(
                new CornerCompanion(
                        "GO_TO_JAIL",
                        "30",
                        "tile.gotojail"
                ),
                "tile.gotojail"
        );
    }

    public static ArrayList<? extends Tile> upperBarTiles = new ArrayList<>(Arrays.asList(
            templateTile(),
            templateTile(),
            templateTile(),
            templateTile(),
            initChestTile(),
            templateTile(),
            templateTile(),
            templateUtilityTile(), // TODO
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
            new StreetTile("tile.street12"),
            new ChanceTile("tile.chance"),
            new StreetTile("tile.street13"),
            new StreetTile("tile.street14"),
            new RailwayTile("tile.railway3"),
            new StreetTile("tile.street15"),
            new StreetTile("tile.street16"),
            new UtilityTile("tile.utility2"),
            new StreetTile("tile.street17")));

    public static ArrayList<? extends Tile> leftBarTiles = new ArrayList<>(Arrays.asList(
            new StreetTile("tile.street05"),
            new StreetTile("tile.street04"),
            new ChanceTile("tile.chance"),
            new StreetTile("tile.street03"),
            new RailwayTile("tile.railway1"),
            new TaxTile("tile.tax1"),
            new StreetTile("tile.street02"),
            new ChestTile("tile.chest"),
            new StreetTile("tile.street01")));

    public static ArrayList<? extends Tile> cornerTiles = new ArrayList<>(Arrays.asList(
            initStartTile(),
            initJailCornerTile(),
            initFreeParkingCornerTile(),
            initGoToJailCornerTile()
            ));

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
