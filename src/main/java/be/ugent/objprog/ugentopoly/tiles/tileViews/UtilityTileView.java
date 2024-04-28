package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.UtilityTileModel;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class UtilityTileView extends SmallTileView {

    public UtilityTileView(UtilityTileModel model) {
        super(model);
        setup();
    }

    @Override
    protected void setup() {
        UtilityTileModel model = (UtilityTileModel) this.model;
        ImageView imageView = new ImageView(model.getImage());

        imageView.setFitHeight(SHORT_SIDE - 13);
        imageView.setFitWidth(LONG_SIDE - 13);
        imageView.setPreserveRatio(true);

        StackPane pane = new StackPane(imageView);
        pane.setPrefWidth(Double.MAX_VALUE);
        pane.setPrefHeight(Double.MAX_VALUE);
        pane.setPadding(new Insets(10, 10, 10, 10));

        getChildren().addAll(pane, badgeHolders, tileButton);
    }

    public UtilityTileModel getModel() {
        return (UtilityTileModel) model;
    }
}