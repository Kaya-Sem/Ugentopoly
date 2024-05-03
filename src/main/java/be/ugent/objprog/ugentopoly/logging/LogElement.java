package be.ugent.objprog.ugentopoly.logging;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class LogElement extends HBox {
    private static final int SPACING = 7;

    public LogElement(String playerName, String actionPerformed) {
        Label nameLabel = new Label(playerName);
        nameLabel.getStyleClass().add("bold-label-medium");
        Label action = new Label(actionPerformed);

        setAlignment(Pos.CENTER_LEFT);
        setSpacing(SPACING);

        getChildren().addAll(nameLabel, action);
    }

    public LogElement(String message) {
        Label messageLabel = new Label(message);
        getChildren().addAll(messageLabel);
    }
}