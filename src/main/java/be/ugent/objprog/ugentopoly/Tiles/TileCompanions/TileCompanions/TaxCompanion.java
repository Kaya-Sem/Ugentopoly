package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.TileCompanions;

public record TaxCompanion(
        String type,
        String position,
        String id,
        String amount
) implements TileObject {
}
