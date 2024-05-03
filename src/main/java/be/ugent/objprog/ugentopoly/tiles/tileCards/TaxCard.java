package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class TaxCard extends VerticalCard {
    public TaxCard(Image image, String text, String cost){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(TileView.LONG_SIDE);
        imageView.setFitWidth(TileView.LONG_SIDE);

        Label textLabel = new Label(text);
        textLabel.getStyleClass().add("bold-label-large");

        Label costLabel = new Label(cost + "€");
        costLabel.getStyleClass().add("thin-label-medium");

        vBox.getChildren().addAll(imageView, textLabel, costLabel);
        getChildren().addAll(vBox);
    }
}