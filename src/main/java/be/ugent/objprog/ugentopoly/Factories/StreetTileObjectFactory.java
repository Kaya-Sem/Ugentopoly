package be.ugent.objprog.ugentopoly.Factories;

import be.ugent.objprog.ugentopoly.TileObjects.StreetTileObject;

public class StreetTileObjectFactory {

    public StreetTileObject forge(
            String position,
            String area,
            String id,
            String cost,
            String rent0,
            String rent1,
            String rent2,
            String rent3,
            String rent4,
            String rent5

    ) {
        return new StreetTileObject(
                position,
                area,
                id,
                cost,
                rent0,
                rent1,
                rent2,
                rent3,
                rent4,
                rent5
        );
    }
}


// TODO create factories for all the tile classes