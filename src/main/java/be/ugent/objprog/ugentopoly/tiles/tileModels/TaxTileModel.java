package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.DisplayedCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.function.Consumer;

public class TaxTileModel extends TileModel{
    private final int amount;

    public TaxTileModel(String id, int position, int amount, DisplayedCardController controller) {
        super(id, position, controller);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (gameModel -> {
            gameModel.changeBonusPot(amount);
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            currentPlayer.changeBalance(-amount);
            gameModel.addLog(currentPlayer.getPlayerName(), "betaald €" + amount);
        });
    }
}