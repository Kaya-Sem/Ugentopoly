package be.ugent.objprog.ugentopoly.TileObjects;

public record TaxObject(
        String position,
        String id,
        String amount
) implements TileObject {
}
