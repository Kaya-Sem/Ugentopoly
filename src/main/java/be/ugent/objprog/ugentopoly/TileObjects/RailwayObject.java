package be.ugent.objprog.ugentopoly.TileObjects;

public record RailwayObject(
        String position,
        String id,
        String cost,
        String rent
) implements TileObject {
}
