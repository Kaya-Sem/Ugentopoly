package be.ugent.objprog.ugentopoly.logging;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class LogElement extends HBox {
    private static final int SPACING = 9;

    public LogElement(String playerName, String actionPerformed) {
        Label name = new Label(playerName);
        name.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        Label action = new Label(actionPerformed);

        setAlignment(Pos.CENTER_LEFT);
        setSpacing(SPACING);

        getChildren().addAll(name, action);
    }
}