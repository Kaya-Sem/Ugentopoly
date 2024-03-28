package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.TileCompanions;

public record RailwayCompanion(
        String type,
        String position,
        String id,
        String cost,
        String rent
) implements TileObject {
}
