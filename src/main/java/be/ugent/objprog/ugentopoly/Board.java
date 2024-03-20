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

        List<HorizontalTile> hTiles2 = List.of(
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

        List<VerticalTile> vTiles2 = List.of(
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
        HorizontalBar topRow = new HorizontalBar();
        HorizontalBar bottomRow = new HorizontalBar();
        VerticalBar leftBar = new VerticalBar();
        VerticalBar rightBar = new VerticalBar();

        // populate tiles
        topRow.populate(vTiles);
        bottomRow.populate(vTiles2);
        leftBar.populate(hTiles2);
        rightBar.populate(hTiles);

        // TODO make positions constant
        // Add components to the GridPane
        add(topRow,1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        // add middle board
        add(new MiddleSection(), 1, 1);

        // Adding corner tiles
        add(new CornerTile(), 0, 0); // top left
        add(new CornerTile(), 2, 0); // top right
        add(new CornerTile(), 0, 2); // bottom right
        add(new CornerTile(), 2, 2); // bottom left



    }
}
