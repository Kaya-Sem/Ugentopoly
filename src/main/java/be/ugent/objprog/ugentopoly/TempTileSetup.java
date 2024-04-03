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

    public static TaxTile initTaxTile(String id, String amount){
        return new TaxTile(
                new TaxCompanion(
                        "TAX",
                        "4",
                        id,
                       amount
                ),
                id
        );
    }

    protected static StreetTile initStreetTile(String area, String id) {
        return new StreetTile(
                new StreetCompanion(
                        "STREET",
                        "1",
                        area,
                        id,
                        "60",
                        "2",
                        "10",
                        "30",
                        "90",
                        "160",
                        "250"),
                id,
                colors.get(area)
                );
    }

    protected static RailwayTile initRailwayTile(String id){
     return new RailwayTile(
             new RailwayCompanion(
                     "RAILWAY",
                     "5",
                     id,
                     "200",
                     "50"
             ),
             id
     );
    }

    protected static UtilityTile initUtilityTile(String id){
        return new UtilityTile(
                new UtilityCompanion(
                       "UTILITY",
                "12",
                        id,
                        "150"),
               id
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
            initStreetTile("area3", "tile.street06"),
            initUtilityTile("tile.utility1"),
            initStreetTile("area3", "tile.street07"),
            initStreetTile("area3", "tile.street08"),
            initRailwayTile("tile.railway2"),
            initStreetTile("area4", "tile.street09"),
            initChestTile(),
            initStreetTile("area4", "tile.street10"),
            initStreetTile("area4", "tile.street11")));

    public static ArrayList<? extends Tile> bottomBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area7", "tile.street18"),
            initStreetTile("area7","tile.street19"),
            initChestTile(),
            initStreetTile("area7","tile.street20"),
            initRailwayTile("tile.railway4"),
            initChanceTile(),
            initStreetTile("area8","tile.street21"),
            initTaxTile("tile.tax2","75"),
            initStreetTile("area8","tile.street22")
    ));

    public static ArrayList<? extends Tile> rightBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area5", "tile.street12"),
            initChanceTile(),
            initStreetTile("area5", "tile.street13"),
            initStreetTile("area5", "tile.street14"),
            initRailwayTile("tile.railway3"),
            initStreetTile("area6", "tile.street15"),
            initStreetTile("area6", "tile.street16"),
            initUtilityTile("tile.utility2"),
            initStreetTile("area6", "tile.street17")));


    public static ArrayList<? extends Tile> leftBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area1", "tile.street01"),
            initChestTile(),
            initStreetTile("area1", "tile.street02"),
            initTaxTile("tile.tax1", "200"),
            initRailwayTile("tile.railway1"),
            initStreetTile("area2", "tile.street03"),
            initChanceTile(),
            initStreetTile("area2","tile.street04"),
            initStreetTile("area2", "tile.street05")
            ));


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
