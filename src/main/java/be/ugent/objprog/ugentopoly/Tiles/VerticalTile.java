package be.ugent.objprog.ugentopoly.Tiles;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VerticalTile extends Tile {
    public VerticalTile() {
        setPrefWidth(Tile.SHORT_SIDE);
        setPrefHeight(Tile.LONG_SIDE);
        //setText("vertical tile");
        Region sliver = new Region();
        sliver.setPrefWidth(30);
        sliver.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        getChildren().add(sliver);
        setHgrow(sliver, Priority.ALWAYS);
    }
}
