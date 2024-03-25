package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.Bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.Bars.VerticalBar;
import be.ugent.objprog.ugentopoly.MiddleSection;
import be.ugent.objprog.ugentopoly.TileNodes.CornerTile;
import be.ugent.objprog.ugentopoly.TileNodes.StreetTile;
import be.ugent.objprog.ugentopoly.TileNodes.Tile;
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

        // TODO placeholder lists
        List<? extends Tile> rightTiles = List.of(
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"),
                new StreetTile(180,"button"));

        List<? extends Tile> leftTiles = List.of(
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"),
                new StreetTile(0,"button"));

        List<StreetTile> topTiles = List.of(
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"),
                new StreetTile(90,"button"));

        List<StreetTile> bottomTiles = List.of(
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"),
                new StreetTile(270,"button"));

        CornerTile tile1 = new CornerTile();
        CornerTile tile2 = new CornerTile();
        CornerTile tile3 = new CornerTile();
        CornerTile tile4 = new CornerTile();

        List<CornerTile> cornerTiles = List.of(
                tile1,
                tile2,
                tile3,
                tile4
        );

        List<List<? extends Tile>> allTiles = List.of(topTiles, bottomTiles, rightTiles, leftTiles, cornerTiles);

        // initialize tileholders
        HorizontalBar topRow = new HorizontalBar();
        HorizontalBar bottomRow = new HorizontalBar();
        VerticalBar leftBar = new VerticalBar();
        VerticalBar rightBar = new VerticalBar();

        // populate tiles
        topRow.populate(topTiles);
        bottomRow.populate(bottomTiles);
        leftBar.populate(leftTiles);
        rightBar.populate(rightTiles);

        ToggleGroup toggleGroup = new ToggleGroup();
        for (List<? extends Tile> tileList : allTiles) {
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

        // Adding corner tiles
        add(tile1, 0, 0); // top left
        add(tile2, 2, 0); // top right
        add(tile3, 0, 2); // bottom right
        add(tile4, 2, 2); // bottom left



    }
}
