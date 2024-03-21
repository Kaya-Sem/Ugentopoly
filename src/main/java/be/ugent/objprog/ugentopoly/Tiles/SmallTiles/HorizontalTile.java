package be.ugent.objprog.ugentopoly.Tiles.SmallTiles;

import be.ugent.objprog.ugentopoly.Tiles.Tile;

public class HorizontalTile extends Tile {
    public HorizontalTile(){
        setPrefWidth(Tile.LONG_SIDE);
        setPrefHeight(Tile.SHORT_SIDE);
    }
}
