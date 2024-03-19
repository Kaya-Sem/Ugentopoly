package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.Tiles.Tile;

import java.util.List;

public interface Bar {
    void addChildren(List<? extends Tile> tiles);
}
