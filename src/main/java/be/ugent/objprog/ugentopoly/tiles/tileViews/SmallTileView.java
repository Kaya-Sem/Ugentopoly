package be.ugent.objprog.ugentopoly.tiles.tileViews;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.Observable;

// TODO explain why not abstract and so using protected constructor
public class SmallTileView extends TileView {

    protected SmallTileView(TileModel model) {
        super(model);
        setMinHeight(SHORT_SIDE);
        setMaxHeight(SHORT_SIDE);
        setMinWidth(LONG_SIDE);
        setMaxWidth(LONG_SIDE);
    }

    @Override
    public void invalidated(Observable observable) {
        super.invalidated(observable);
    }
}