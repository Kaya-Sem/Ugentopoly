package be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

public class CornerTileView extends TileView {

    public CornerTileView(TileModel model) {
        super(model);
        setMinHeight(LONG_SIDE);
        setMaxHeight(LONG_SIDE);
        setMaxWidth(LONG_SIDE);
        setMinWidth(LONG_SIDE);
    }
}