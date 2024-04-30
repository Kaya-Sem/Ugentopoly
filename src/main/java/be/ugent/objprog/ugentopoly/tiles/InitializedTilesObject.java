package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;

public record InitializedTilesObject(
        TileModel[] tileModelArray,
        TileView[] leftTilesViewArray,
        TileView[] topTilesViewArray,
        TileView[] rightTilesViewArray,
        TileView[] bottomTilesViewArray,
        TileView[] cornerTilesViewArray
) {
}