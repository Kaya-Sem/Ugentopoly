package be.ugent.objprog.ugentopoly.tiles.tileModels;

public class TaxTileModel extends TileModel{
    private final int amount;
    public TaxTileModel(String id, int position, int amount) {
        super(id, position);
        this.amount = amount;
    }
}