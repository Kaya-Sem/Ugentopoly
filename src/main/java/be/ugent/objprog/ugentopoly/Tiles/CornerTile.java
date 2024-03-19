package be.ugent.objprog.ugentopoly.Tiles;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CornerTile extends Tile{
    public CornerTile() {
        super.
        setPrefHeight(Tile.LONG_SIDE);
        setPrefWidth(Tile.LONG_SIDE);
        setAlignment(Pos.CENTER);

        Label text = new Label("cornertile");
        getChildren().addAll(text);

    }
}
