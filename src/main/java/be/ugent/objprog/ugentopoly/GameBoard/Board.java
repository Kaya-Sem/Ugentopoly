package be.ugent.objprog.ugentopoly.GameBoard;

import be.ugent.objprog.ugentopoly.Bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.Bars.VerticalBar;
import be.ugent.objprog.ugentopoly.TempTileSetup;
import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class Board extends GridPane {
    public static final double BOARD_SIZE = Ugentopoly.BOARD_SIZE;
    public static final int SMALL_TILES = 9;
    protected static final double MIDDLE_AREA_SIZE = (BOARD_SIZE / Ugentopoly.SMALL_TILES) * SMALL_TILES;

    public static final ToggleGroup TOGGLE_GROUP = new ToggleGroup();

    public Board() {
        setPrefSize(BOARD_SIZE, BOARD_SIZE);
        setMaxHeight(BOARD_SIZE);
        setMaxWidth(BOARD_SIZE);
        setAlignment(Pos.CENTER);

        // TODO put constraints in constant
        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(Tile.LONG_SIDE), // Left bar column
                new ColumnConstraints(MIDDLE_AREA_SIZE) // Mid section column
        );

        getRowConstraints().addAll( // Set row constraints
                new RowConstraints(Tile.LONG_SIDE), // Top row
                new RowConstraints(MIDDLE_AREA_SIZE) // Mid-section row
        );


        /*
        load a map of initialised tiles

        top_row -> top row tiles
        bottom_row -> bottom row tiles
        right_row -> right bar tiles
        left_row -> left bar tiles
        corners -> corner tiles

        */

        //TODO fix
        //TileInitializer tileInitializer = new TileInitializer();
        //Map<String, ArrayList<? extends Tile>> tileMap = tileInitializer.initialiseTiles();

        // initialize tileholders
        HorizontalBar topRow = new HorizontalBar();
        HorizontalBar bottomRow = new HorizontalBar();
        VerticalBar leftBar = new VerticalBar();
        VerticalBar rightBar = new VerticalBar();

        // populate tiles with lists from map
        topRow.populate(TempTileSetup.upperBarTiles);
        bottomRow.populate(TempTileSetup.bottomBarTiles);
        leftBar.populate(TempTileSetup.leftBarTiles);
        rightBar.populate(TempTileSetup.rightBarTiles);

        // create a new toggle group for all the tiles
        /*ToggleGroup toggleGroup = new ToggleGroup();
        for (ArrayList<? extends Tile> tileList : tileMap.values()) {
            for (Tile tile : tileList) {
                tile.setToggleGroup(toggleGroup);
            }
        }*/

        // TODO make positions constant
        // Add components to the GridPane
        add(topRow,1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        // Add middle board
        add(new MiddleSection(), 1, 1);

        // Adding corner tiles by loading the corners from the map for easier access
        List<? extends Tile> corners = List.of();

        add(TempTileSetup.templateCornerTile() , 0, 0); // top left
        add(TempTileSetup.templateCornerTile(), 2, 0); // top right
        add(TempTileSetup.templateCornerTile(), 0, 2); // bottom right
        add(TempTileSetup.templateCornerTile(), 2, 2); // bottom left



    }
}
