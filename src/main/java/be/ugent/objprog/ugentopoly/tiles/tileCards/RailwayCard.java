package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.CustomImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.RailwayTileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class RailwayCard extends VerticalCard{
    public RailwayCard(RailwayTileModel model) {
        Label nameLabel = new Label(model.getName());
        Label ownerLabel = new Label();
        Label costLabel = new Label("€" + model.getCost());
        costLabel.setTextAlignment(TextAlignment.LEFT);

        ownerLabel.textProperty().bind(model.ownerProperty());
        ownerLabel.getStyleClass().add("owner-label");

        nameLabel.getStyleClass().add("bold-label-large");

        VBox title = new VBox(nameLabel, costLabel);
        title.setAlignment(Pos.CENTER);

        Label rentLabel = new Label("rent €" + model.getRent());
        rentLabel.getStyleClass().add("bold-label-medium");

        ImageView imageView = new CustomImageView(TileView.LONG_SIDE, TileView.LONG_SIDE, model.getImage());

        VBox vBox = new VBox(imageView, title, ownerLabel, rentLabel);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPrefHeight(Double.MAX_VALUE);
        vBox.setPrefWidth(Double.MAX_VALUE);
        vBox.setSpacing(10);

        getChildren().addAll(vBox);
    }
}