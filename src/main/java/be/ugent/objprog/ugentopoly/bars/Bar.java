package be.ugent.objprog.ugentopoly.bars;

import be.ugent.objprog.ugentopoly.tiles.tile.Tile;

import java.util.List;

public interface Bar {
    void populate();

    void applyRotation(double angle);
}