package be.ugent.objprog.ugentopoly.logging;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class LogElement extends HBox {

    public LogElement(String playerName, String actionPerformed) {
        Label name = new Label(playerName);
        name.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        Label action = new Label(actionPerformed);

        // TODO add styling
        getChildren().addAll(name, action);
    }
}