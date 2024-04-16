package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

public abstract class SmallTile extends Tile {

    public SmallTile(TileModel model) {
        super(model);
        setMinHeight(SHORT_SIDE);
        setMaxHeight(SHORT_SIDE);
        setMinWidth(LONG_SIDE);
        setMaxWidth(LONG_SIDE);
    }
}