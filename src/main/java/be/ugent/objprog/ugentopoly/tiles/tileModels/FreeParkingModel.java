package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.function.Consumer;

public class FreeParkingModel extends TileModel{
    public FreeParkingModel(String id, int position) {
        super(id, position);
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            int amount = gameModel.getBonusPot();
            gameModel.setBonusPot(0);
            currentPlayer.changeBalance(amount);

            gameModel.addLog(currentPlayer.getPlayerName(), "kreeg " + amount + "€ uit de bonuspot!");
        };
    }
}