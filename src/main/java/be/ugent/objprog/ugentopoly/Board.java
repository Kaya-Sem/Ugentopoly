package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.tiles.*;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class Board extends GridPane {
    public static final int BOARD_WIDTH = 845;
    public static final int BOARD_HEIGHT = 845;
    public static final int SMALL_TILES = 9;
    protected static final double MIDDLE_AREA_SIZE = (845.5 / 13) * SMALL_TILES;

    public Board() {
        setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);
        setMaxHeight(BOARD_HEIGHT);
        setMaxWidth(BOARD_WIDTH);
        setAlignment(Pos.CENTER);

        HBox upperRow = new HBox();
        HBox bottomRow = new HBox();
        VBox leftBar = new VBox();
        VBox rightBar = new VBox();


        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(Tile.LONG_SIDE ), // Left bar column
                new ColumnConstraints(MIDDLE_AREA_SIZE) // Mid section column
        );

        getRowConstraints().addAll( // Set row constraints
                new RowConstraints(Tile.LONG_SIDE ), // Top row
                new RowConstraints(MIDDLE_AREA_SIZE) // Mid-section row
        );

        // TODO find solution to fill children
        // fill upper row
        upperRow.getChildren().add(new CornerTile());
        for (int i = 0; i < SMALL_TILES; i++) {
            upperRow.getChildren().add(new VerticalTile());
        }
        upperRow.getChildren().add(new CornerTile());

        // fill bottom row
        bottomRow.getChildren().add(new CornerTile());
        for (int i = 0; i < SMALL_TILES; i++) {
            bottomRow.getChildren().add(new VerticalTile());
        }
        bottomRow.getChildren().add(new CornerTile());

        for (int i = 0; i < SMALL_TILES; i++) {
            leftBar.getChildren().add(new HorizontalTile());
        }
        for (int i = 0; i < SMALL_TILES; i++) {
            rightBar.getChildren().add(new HorizontalTile());
        }

        MiddleSection middleSection = new MiddleSection();

        // Add components to the GridPane
        add(upperRow, 0, 0, 3, 1); // Top row spans all 3 columns
        add(leftBar, 0, 1, 1, 1);
        add(middleSection, 1, 1, 1, 1); // exactly in the middle
        add(rightBar, 2, 1, 1, 1);
        add(bottomRow, 0, 2, 3, 1); // Bottom row spans 3 columns
    }
}
