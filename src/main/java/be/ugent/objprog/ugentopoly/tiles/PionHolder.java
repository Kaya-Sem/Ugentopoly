package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PionHolder extends HBox {
    public PionHolder(){
        setMaxHeight(Tile.SHORT_SIDE);
        setMinHeight(Tile.SHORT_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setAlignment(Pos.CENTER);
        setSpacing(10);
    }
}