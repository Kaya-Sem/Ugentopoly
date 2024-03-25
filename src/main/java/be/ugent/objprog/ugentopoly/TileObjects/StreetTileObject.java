package be.ugent.objprog.ugentopoly.TileObjects;

public record StreetTileObject(
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
) implements TileObject {
}
