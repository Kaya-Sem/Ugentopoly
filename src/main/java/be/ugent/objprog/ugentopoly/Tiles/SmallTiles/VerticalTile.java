package be.ugent.objprog.ugentopoly.Tiles.SmallTiles;

import be.ugent.objprog.ugentopoly.Tiles.Tile;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class VerticalTile extends Tile {
    public VerticalTile() {
        setPrefWidth(Tile.SHORT_SIDE);
        setPrefHeight(Tile.LONG_SIDE);
    }
}
