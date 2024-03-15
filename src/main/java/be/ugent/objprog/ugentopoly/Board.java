package be.ugent.objprog.ugentopoly;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Board {
    VBox board;

    HBox upperRow;

    HBox midSection;

    HBox bottomRow;

    public Board(){
        board = new VBox();
        upperRow = new HBox();
        bottomRow = new HBox();
        midSection = new HBox();

        midSection.getChildren().addAll(new VBox(), new HBox(), new VBox() );

        board.getChildren().addAll(upperRow, midSection, bottomRow);

    }
}
