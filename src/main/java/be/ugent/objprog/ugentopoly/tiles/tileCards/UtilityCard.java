package be.ugent.objprog.ugentopoly.tiles.tileCards;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UtilityCard extends HorizontalCard {
    private static final double PADDING = 40;


    public UtilityCard(Image image, String cost){


        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(WIDTH - PADDING);
        imageView.setFitHeight(HEIGHT - PADDING);

        Label amount = new Label( cost + "€");
        amount.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        VBox vBox = new VBox( imageView, amount);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        getChildren().addAll(vBox);
    }
}