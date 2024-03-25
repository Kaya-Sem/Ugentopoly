package be.ugent.objprog.ugentopoly.Factories;

import be.ugent.objprog.ugentopoly.TileNodes.Tile;

public interface Factory<T extends Tile>{
    T forge();
}
