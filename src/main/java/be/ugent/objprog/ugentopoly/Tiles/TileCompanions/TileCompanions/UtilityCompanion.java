package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.TileCompanions;

public record UtilityCompanion(
        String type,
        String position,
        String id,
        String cost
) implements TileObject {
}