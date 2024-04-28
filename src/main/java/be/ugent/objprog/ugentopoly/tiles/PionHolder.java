package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PionHolder extends HBox {
    public PionHolder(){
        setMaxHeight(TileView.SHORT_SIDE);
        setMinHeight(TileView.SHORT_SIDE);
        setMaxWidth(TileView.LONG_SIDE);
        setMinWidth(TileView.LONG_SIDE);
        setAlignment(Pos.CENTER);
        setSpacing(10);
    }
}