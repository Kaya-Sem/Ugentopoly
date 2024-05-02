package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileModels.UtilityTileModel;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class UtilityTileView extends SmallTileView {

    protected static final int SIZE = 13;

    public UtilityTileView(UtilityTileModel model) {
        super(model);

        ImageView imageView = new ImageView(model.getImage());

        imageView.setFitHeight(SHORT_SIDE - SIZE);
        imageView.setFitWidth(LONG_SIDE - SIZE);
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