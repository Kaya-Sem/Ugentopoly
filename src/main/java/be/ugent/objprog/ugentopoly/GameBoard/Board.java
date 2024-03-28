package be.ugent.objprog.ugentopoly.GameBoard;

import be.ugent.objprog.ugentopoly.Bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.Bars.VerticalBar;
import be.ugent.objprog.ugentopoly.TileInitializer;
import be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile.Tile;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;
import java.util.Map;

public class Board extends GridPane {
    public static final double BOARD_SIZE = Ugentopoly.BOARD_SIZE;
    public static final int SMALL_TILES = 9;
    protected static final double MIDDLE_AREA_SIZE = (BOARD_SIZE / Ugentopoly.SMALL_TILES) * SMALL_TILES;

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
        Map<String, List<? extends Tile>> tileMap = TileInitializer.initialiseTiles();

        // initialize tileholders
        HorizontalBar topRow = new HorizontalBar();
        HorizontalBar bottomRow = new HorizontalBar();
        VerticalBar leftBar = new VerticalBar();
        VerticalBar rightBar = new VerticalBar();

        // populate tiles with lists from map
        topRow.populate(tileMap.get("top_row"));
        bottomRow.populate(tileMap.get("bottom_row"));
        leftBar.populate(tileMap.get("left_bar"));
        rightBar.populate(tileMap.get("right_bar"));

        // create a new toggle group for all the tiles
        ToggleGroup toggleGroup = new ToggleGroup();
        for (List<? extends Tile> tileList : tileMap.values()) {
            for (Tile tile : tileList) {
                tile.setToggleGroup(toggleGroup);
            }
        }

        // TODO make positions constant
        // Add components to the GridPane
        add(topRow,1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        // Add middle board
        add(new MiddleSection(), 1, 1);

        // Adding corner tiles by loading the corners from the map for easier access
        List<? extends Tile> corners = tileMap.get("corners");
        add(corners.get(0), 0, 0); // top left
        add(corners.get(1), 2, 0); // top right
        add(corners.get(2), 0, 2); // bottom right
        add(corners.get(3), 2, 2); // bottom left



    }
}
