package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.GameBoard.MiddleSection;
import javafx.scene.layout.StackPane;

public class CustomButtonHandler {
    public static MiddleSection middleSection = null;

    public static void updateDisplayedCard(Record companion) {
        StackPane pane = new StackPane();
        middleSection.updateDisplayedCard(pane);
    }
}