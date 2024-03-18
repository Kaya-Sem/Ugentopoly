package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.tiles.CornerTile;
import be.ugent.objprog.ugentopoly.tiles.HorizontalTile;
import be.ugent.objprog.ugentopoly.tiles.MiddleSection;
import be.ugent.objprog.ugentopoly.tiles.VerticalTile;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class Board extends GridPane {
    public static final int BOARD_WIDTH = 845;
    public static final int BOARD_HEIGHT = 845;
    public static final int NUM_TILES = 13;
    public static final int TILE_HEIGHT = (BOARD_HEIGHT / NUM_TILES) * 2;
    public static final int TILE_WIDTH = (BOARD_WIDTH / NUM_TILES) * 2;
    public static final int SMALL_TILES = 9;

    public Board() {
        setHeight(BOARD_HEIGHT);
        setWidth(BOARD_WIDTH);
        setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);
        setMaxHeight(BOARD_HEIGHT);
        setMaxWidth(BOARD_WIDTH);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #A09ABC;");

        HBox upperRow = new HBox();
        HBox bottomRow = new HBox();
        VBox leftBar = new VBox();
        VBox rightBar = new VBox();


        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(TILE_WIDTH ), // Left bar column
                new ColumnConstraints((845 / 13) * 9) // Mid section column
        );

        getRowConstraints().addAll( // Set row constraints
                new RowConstraints(TILE_HEIGHT ), // Top row
                new RowConstraints((845.0 / 13) *9) // Mid-section row
        );

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

        MiddleSection middleBoard = new MiddleSection();

        // Add components to the GridPane
        add(upperRow, 0, 0, 3, 1); // Top row spans 3 columns
        add(leftBar, 0, 1, 1, 1);
        add(middleBoard, 1, 1, 1, 1);
        add(rightBar, 2, 1, 1, 1);
        add(bottomRow, 0, 2, 3, 1); // Bottom row spans 3 columns
    }
}
