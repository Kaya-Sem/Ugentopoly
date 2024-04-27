package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.GameModel;

import java.util.function.Consumer;

public class TaxTileModel extends TileModel{
    private final int amount;

    public TaxTileModel(String id, int position, int amount) {
        super(id, position);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (gameModel -> {
            gameModel.changeBonusPot(this.amount);
            gameModel.getCurrentPlayerMove().changeBalance(-amount);
            System.out.println("taxtilemodel");
        });
    }
}