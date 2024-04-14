package be.ugent.objprog.ugentopoly.tiles.tileModels;

public class UtilityTileModel extends TileModel{

    private final int cost;

    public UtilityTileModel(String id, int position, int cost) {
        super(id, position);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}