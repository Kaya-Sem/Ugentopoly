package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.tiles.CornerTile;
import be.ugent.objprog.ugentopoly.tiles.HorizontalTile;
import be.ugent.objprog.ugentopoly.tiles.VerticalTile;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends GridPane {
    public static final int BOARD_WIDTH = 845;
    public static final int BOARD_HEIGHT = 845;

    public Board() {
        setHeight(BOARD_HEIGHT);
        setWidth(BOARD_WIDTH);
        setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #119dcb;");

        HBox upperRow = new HBox();
        HBox bottomRow = new HBox();
        HBox midSection = new HBox();
        VBox leftBar = new VBox();
        VBox rightBar = new VBox();


        // fill upper row
        upperRow.getChildren().add(new CornerTile());
        for (int i = 0; i < 11; i++) {
            upperRow.getChildren().add(new VerticalTile());
        }
        upperRow.getChildren().add(new CornerTile());


        // fill bottom row
        bottomRow.getChildren().add(new CornerTile());
        for (int i = 0; i < 11; i++) {
            bottomRow.getChildren().add(new VerticalTile());
        }
        bottomRow.getChildren().add(new CornerTile());

        for (int i = 0; i < 11; i++) {
            leftBar.getChildren().add(new HorizontalTile());
        }
        for (int i = 0; i < 11; i++) {
            rightBar.getChildren().add(new HorizontalTile());
        }


        midSection.getChildren().addAll(leftBar, new HBox(), rightBar );

        this.getChildren().addAll(upperRow, midSection, bottomRow);

    }
}
