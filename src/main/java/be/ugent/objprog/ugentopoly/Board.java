package be.ugent.objprog.ugentopoly;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board extends VBox {
    public static final int BOARD_WIDTH = 845;

    public static final int BOARD_HEIGHT = 845;
    VBox board;



    public Board() {
        setPrefSize(BOARD_WIDTH, BOARD_HEIGHT);
        setStyle("-fx-background-color: lightblue;");

        HBox upperRow = new HBox();
        HBox bottomRow = new HBox();
        HBox midSection = new HBox();

        for (int i = 0; i < 13; i++) {
            upperRow.getChildren().add(new Button("button"));
        }

        midSection.getChildren().addAll(new VBox(), new HBox(), new VBox() );

        this.getChildren().addAll(upperRow, midSection, bottomRow);
    }
}
