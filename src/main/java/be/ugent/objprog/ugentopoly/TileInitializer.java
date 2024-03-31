package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.Factories.TileFactory;
import be.ugent.objprog.ugentopoly.Parsers.XMLParser;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;

import java.util.*;

// TODO sort on position?

public class TileInitializer {
    private Tile[] tilesArray;

    public TileInitializer() {
        this.tilesArray = new Tile[40];
    }

    /**
     * Initializes the tiles for the game.
     * @return A map containing initialized tiles grouped by categories.
     */
    public Map<String, ArrayList<? extends Tile>> initialiseTiles() {
        XMLParser parser = new XMLParser();
        TileFactory factory = new TileFactory();

        Map<String, Map<String, String>> tilesData = parser.parseTileData();

        for (Map.Entry<String, Map<String, String>> entry : tilesData.entrySet()) {
            Map<String, String> tileProperties = entry.getValue();
            Tile tile = factory.forge(tileProperties);
            int index = 0;
            try {
                index = Integer.parseInt(tileProperties.get("position"));
            } catch (NumberFormatException e) {
                System.err.println("Error parsing position as an integer! " + e.getMessage());
            }
            tilesArray[index] = tile;

        }

        if (tilesArray.length == 0) {
            System.err.println("Error: tilesArray is empty. No tiles initialized.");}

        ArrayList<? extends Tile> upperBarTiles = new ArrayList<>(Arrays.asList(
                tilesArray[11],
                tilesArray[12],
                tilesArray[13],
                tilesArray[14],
                tilesArray[15],
                tilesArray[16],
                tilesArray[17],
                tilesArray[18],
                tilesArray[19]
        ));

        ArrayList<? extends Tile> bottomBarTiles = new ArrayList<>(Arrays.asList(
                tilesArray[31],
                tilesArray[32],
                tilesArray[33],
                tilesArray[34],
                tilesArray[35],
                tilesArray[36],
                tilesArray[37],
                tilesArray[38],
                tilesArray[39]
        ));

        ArrayList<? extends Tile> rightBarTiles = new ArrayList<>(Arrays.asList(
                tilesArray[21],
                tilesArray[22],
                tilesArray[23],
                tilesArray[24],
                tilesArray[25],
                tilesArray[26],
                tilesArray[27],
                tilesArray[28],
                tilesArray[29]
        ));

        ArrayList<? extends Tile> leftBarTiles = new ArrayList<>(Arrays.asList(
                tilesArray[1],
                tilesArray[2],
                tilesArray[3],
                tilesArray[4],
                tilesArray[5],
                tilesArray[6],
                tilesArray[7],
                tilesArray[8],
                tilesArray[9]
        ));

        ArrayList<? extends Tile> cornerTiles = new ArrayList<>(Arrays.asList(
                tilesArray[0],
                tilesArray[10],
                tilesArray[20],
                tilesArray[30]
        ));

        return new HashMap<>() {
            {
                put("top_row", upperBarTiles);
                put("bottom_row", bottomBarTiles);
                put("right_bar", rightBarTiles);
                put("left_bar", leftBarTiles);
                put("corners", cornerTiles);
            }
        };
    }

    // Test method
    private static void test() {
        TileInitializer initializer = new TileInitializer();
        Map<String, ArrayList<? extends Tile>> initializedTiles = initializer.initialiseTiles();
        // You can perform further testing or assertions here
    }

    public static void main(String[] args) {
        test();
    }
}
