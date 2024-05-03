package be.ugent.objprog.ugentopoly.gamecards;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class GameCardAlert extends Alert {

    public GameCardAlert(String message) {
        super(AlertType.NONE);
        setTitle("");
        setHeaderText(null);
        setContentText(message);

        setGraphic(null);

        ButtonType closeButton = new ButtonType("OK");
        getButtonTypes().add(closeButton);

        Button okButton = (Button) getDialogPane().lookupButton(closeButton);
        okButton.setOnAction(e -> close());
    }
}