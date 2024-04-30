package be.ugent.objprog.ugentopoly.gamecards;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.CustomImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameCardAlert extends Alert {
    private static final int HEIGHT = 100;
    private static final int WIDTH = 100;

    public GameCardAlert(String message) {
        super(AlertType.NONE);
        setTitle("Kanskaart");
        setHeaderText(null);
        setContentText(message);

        Image image = new CustomImage("chance.png");
        ImageView imageView = new CustomImageView(HEIGHT, WIDTH, image);
        setGraphic(imageView);

        ButtonType closeButton = new ButtonType("OK");
        getButtonTypes().add(closeButton);

        Button okButton = (Button) getDialogPane().lookupButton(closeButton);
        okButton.setOnAction(e -> close());
    }
}