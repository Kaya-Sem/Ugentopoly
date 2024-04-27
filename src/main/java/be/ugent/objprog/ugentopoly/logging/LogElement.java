package be.ugent.objprog.ugentopoly.logging;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class LogElement extends HBox {

    public LogElement(String playerName, String actionPerformed) {
        Label name = new Label(playerName);
        Label action = new Label(actionPerformed);

        getChildren().addAll(name, action);
    }
}