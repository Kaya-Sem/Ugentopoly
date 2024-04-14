/*package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.tiles.tileViews.*;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.FreeParkingCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.GoToJailCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.JailCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.StartCornerTile;
import be.ugent.objprog.ugentopoly.tiles.tileCompanions.*;

public class TempTileSetup {

    static final XMLParser parser = new XMLParser();
    static final Map<String, String> colors = parser.areaColors();

    public static JailCornerTile initJailCornerTile() {
        return new JailCornerTile(
                new CornerCompanion(
                        "JAIL",
                        "10",
                        "tileViews.jail"
                ),
                "tileViews.jail"
        );
    }

    public static ChestTile initChestTile(){
        return new ChestTile(
                new ChestCompanion(
                        "CHEST",
                        "2",
                        "tileViews.chest"
                ),
                "tileViews.chest"
        );
    }

    public static ChanceTile initChanceTile(){
        return new ChanceTile(
                new ChanceCompanion(
                        "CHANCE",
                        "7",
                        "tileViews.chance"
                ),
                "tileViews.chance"
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

    protected static StreetTileView initStreetTile(
            String area,
            String id,
            String cost,
            String rent0,
            String rent1,
            String rent2,
            String rent3,
            String rent4,
            String rent5
            ) {
        return new StreetTileView(
                new StreetCompanion(
                        "STREET",
                        "1",
                        area,
                        id,
                        cost,
                        rent0,
                        rent1,
                        rent2,
                        rent3,
                        rent4,
                        rent5),
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
                        "tileViews.start"
                ),
                "tileViews.start"
        );
    }

    public static FreeParkingCornerTile initFreeParkingCornerTile(){
        return new FreeParkingCornerTile(
                new CornerCompanion(
                        "FREE_PARKING",
                        "20",
                        "tileViews.freeparking"
                ),
                "tileViews.freeparking"
        );
    }

    public static GoToJailCornerTile initGoToJailCornerTile(){
        return new GoToJailCornerTile(
                new CornerCompanion(
                        "GO_TO_JAIL",
                        "30",
                        "tileViews.gotojail"
                ),
                "tileViews.gotojail"
        );
    }

    public static final ArrayList<? extends Tile> upperBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area3", "tileViews.street06", "140", "10", "50", "150", "450", "625", "750"),
            initUtilityTile("tileViews.utility1"),
            initStreetTile("area3", "tileViews.street07", "140", "10", "50", "150", "450", "625", "750"),
            initStreetTile("area3", "tileViews.street08", "160", "12", "60", "180", "500", "700", "900"),
            initRailwayTile("tileViews.railway2"),
            initStreetTile("area4", "tileViews.street09", "180", "14", "70", "200", "550", "750", "950"),
            initChestTile(),
            initStreetTile("area4", "tileViews.street10", "180", "14", "70", "200", "550", "750", "950"),
            initStreetTile("area4", "tileViews.street11", "200", "16", "80", "220", "600", "800", "1000")
    ));

    public static final ArrayList<? extends Tile> bottomBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area8","tileViews.street22", "400", "50", "200", "600", "1400", "1700", "2000"),
    initTaxTile("tileViews.tax2", "200"),
            initStreetTile("area8","tileViews.street21", "350", "35", "175", "500", "1100", "1300", "1500"),
            initChanceTile(),
            initRailwayTile("tileViews.railway4"),
            initStreetTile("area7","tileViews.street20", "320", "28", "150", "450", "1000", "1200", "1400"),
            initChestTile(),
            initStreetTile("area7","tileViews.street19", "300", "26", "130", "390", "900", "1100", "1275"),
            initStreetTile("area7","tileViews.street18", "300", "26", "130", "390", "900", "1100", "1275")
    ));

    public static final ArrayList<? extends Tile> rightBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area5", "tileViews.street12", "220", "18", "90", "250", "700", "875", "1050"),
            initChanceTile(),
            initStreetTile("area5", "tileViews.street13", "220", "18", "90", "250", "700", "875", "1050"),
            initStreetTile("area5", "tileViews.street14", "240", "20", "100", "300", "750", "925", "1100"),
            initRailwayTile("tileViews.railway3"),
            initStreetTile("area6", "tileViews.street15", "260", "22", "110", "330", "800", "975", "1150"),
            initStreetTile("area6", "tileViews.street16", "260", "22", "110", "330", "800", "975", "1150"),
            initUtilityTile("tileViews.utility2"),
            initStreetTile("area6", "tileViews.street17", "280", "24", "120", "360", "850", "1025", "1200")
    ));


    public static final ArrayList<? extends Tile> leftBarTiles = new ArrayList<>(Arrays.asList(
            initStreetTile("area2", "tileViews.street05", "120", "8", "40", "100", "300", "450", "600"),
            initStreetTile("area2", "tileViews.street04", "100", "6", "30", "90", "270", "400", "550"),
            initChanceTile(),
            initStreetTile("area2","tileViews.street03", "100", "6", "30", "90", "270", "400", "550"),
            initRailwayTile("tileViews.railway1"),
            initTaxTile("tileViews.tax1", "200"),
            initStreetTile("area1", "tileViews.street02", "60", "4", "20", "60", "180", "320", "450"),
            initChestTile(),
            initStreetTile("area1", "tileViews.street01", "60", "2", "10", "30", "90", "160", "250")
            ));


    public static final ArrayList<? extends Tile> cornerTiles = new ArrayList<>(Arrays.asList(
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
}*/