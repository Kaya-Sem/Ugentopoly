package be.ugent.objprog.ugentopoly.Bars;

import be.ugent.objprog.ugentopoly.Tiles.Tile.Tile;

import java.util.List;

public interface Bar {
    void populate(List<? extends Tile> tiles);

    void applyRotation(double angle);
}
