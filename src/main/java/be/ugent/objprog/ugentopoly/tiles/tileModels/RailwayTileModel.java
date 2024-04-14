package be.ugent.objprog.ugentopoly.tiles.tileModels;

public class RailwayTileModel extends TileModel{

    private final int cost;
    private final int rent;

    public RailwayTileModel(String id, int position, int cost, int rent) {
        super(id, position);
        this.cost = cost;
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }

    public int getCost() {
        return cost;
    }
}