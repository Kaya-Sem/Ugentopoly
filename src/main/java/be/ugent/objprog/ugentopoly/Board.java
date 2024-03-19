package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.Bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.Bars.VerticalBar;
import be.ugent.objprog.ugentopoly.Tiles.*;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class Board extends GridPane {
    public static final double BOARD_WIDTH = 845.0;
    public static final double BOARD_HEIGHT = 845.0;
    public static final int SMALL_TILES = 9;
    protected static final double MIDDLE_AREA_SIZE = (845.0 / 13) * SMALL_TILES;

    public Board() {
        setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);
        setMaxHeight(BOARD_HEIGHT);
        setMaxWidth(BOARD_WIDTH);
        setAlignment(Pos.CENTER);

        List<HorizontalTile> hTiles = List.of(
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile(),
                new HorizontalTile());

        List<VerticalTile> vTiles = List.of(
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile(),
                new VerticalTile());

        // initialize tileholders
        HorizontalBar upperRow = new HorizontalBar();
        HorizontalBar bottomRow = new HorizontalBar();
        VerticalBar leftBar = new VerticalBar();
        VerticalBar rightBar = new VerticalBar();


        // populate tiles
        upperRow.addChildren(hTiles);
        leftBar.addChildren(vTiles);
        rightBar.addChildren(vTiles);
        bottomRow.addChildren(hTiles);

        // Adding corner tiles
        add(new CornerTile(), 0, 0); // top left
        add(new CornerTile(), 2, 0); // top right
        add(new CornerTile(), 0, 2); // bottom right
        add(new CornerTile(), 2, 2); // bottom left

        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(Tile.LONG_SIDE), // Left bar column
                new ColumnConstraints(MIDDLE_AREA_SIZE) // Mid section column
        );

        getRowConstraints().addAll( // Set row constraints
                new RowConstraints(Tile.LONG_SIDE), // Top row
                new RowConstraints(MIDDLE_AREA_SIZE) // Mid-section row
        );

        MiddleSection middleSection = new MiddleSection();

        // Add components to the GridPane
        add(upperRow, 1, 0);
        add(leftBar, 2, 1);
        add(middleSection, 1, 1);
        add(rightBar, 0, 1);
        add(bottomRow, 1, 2);
    }
}
