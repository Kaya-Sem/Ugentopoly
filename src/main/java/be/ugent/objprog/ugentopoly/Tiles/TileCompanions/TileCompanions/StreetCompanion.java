package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.TileCompanions;

public record StreetCompanion(
        String type,
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
