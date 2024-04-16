package be.ugent.objprog.ugentopoly.gameBoard;

// TODO create a separate MVC board model with the data

import java.util.Map;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.bars.VerticalBar;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.CornerTile;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Board extends GridPane {

    public static final int SMALL_TILES = 9;
    public static final double BOARD_SIZE = Ugentopoly.BOARD_SIZE;
    protected static final double MIDDLE_AREA_SIZE = (BOARD_SIZE / MiddleSection.SMALL_TILES) * SMALL_TILES;

    public static final MiddleSection middleSection = new MiddleSection();

    public Board(Map<String, Object[]> tileViews) {
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

        // HACK create constructor with preapplied rotation
        // initialize tileholders
        HorizontalBar topRow = new HorizontalBar((Tile[]) tileViews.get("top"));
        HorizontalBar bottomRow = new HorizontalBar((Tile[]) tileViews.get("bottom"));
        VerticalBar leftBar = new VerticalBar((Tile[]) tileViews.get("left"));
        VerticalBar rightBar = new VerticalBar((Tile[]) tileViews.get("right"));

        topRow.applyRotation(90);
        rightBar.applyRotation(180);
        bottomRow.applyRotation(270);

        // TODO make positions constant
        add(topRow, 1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        add(middleSection, 1, 1);

        add((CornerTile) tileViews.get("corners")[0], 0, 2); // bottom left
        add((CornerTile) tileViews.get("corners")[1], 0, 0); // top left
        add((CornerTile) tileViews.get("corners")[2], 2, 0); // top right
        add((CornerTile) tileViews.get("corners")[3], 2, 2); // bottom right

    }
}