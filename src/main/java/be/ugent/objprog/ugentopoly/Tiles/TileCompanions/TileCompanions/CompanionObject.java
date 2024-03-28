package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.TileCompanions;

// TODO implement
public record CompanionObject(
        String type,
        String id,
        String position,
        String area,
        int amount,
        int cost,

        int rent0,
        int rent1,
        int rent2,
        int rent3,
        int rent4,
        int rent5

) implements Companion {

}
