package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

public record TileTuple(TileModel tileModel, Tile tileView) {

}