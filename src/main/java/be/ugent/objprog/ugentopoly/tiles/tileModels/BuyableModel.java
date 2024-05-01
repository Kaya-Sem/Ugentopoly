package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.TilePurchaseAlert;
import javafx.collections.ObservableList;

import java.util.function.Consumer;

public class BuyableModel extends TileModel {

    protected PlayerModel owner = null;
    protected final int cost;

    protected BuyableModel(String tileID, int tilePosition, int cost) {
        super(tileID, tilePosition);
        this.cost = cost;
    }

    public PlayerModel getOwner() {
        return owner;
    }

    public void setOwner(PlayerModel owner) {
        this.owner = owner;
        fireInvalidationEvent();
    }

    public int getCost() {
        return cost;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            String currentPlayerName = currentPlayer.getName();
            ObservableList<TileModel> ownedTiles = currentPlayer.getOwnedTiles();

            if (ownedTiles.contains(this)) {
                gameModel.addLog(currentPlayer.getName(), "belandt op eigen tegel");
                return;
            }

            if (null == owner && currentPlayer.getBalance() >= cost) {
                boolean wasBought = new TilePurchaseAlert(tileName, String.valueOf(cost), card).wasBought();

                if (wasBought) {
                    currentPlayer.changeBalance(-cost);
                    currentPlayer.addBuyable(this);
                    setOwner(currentPlayer);
                    gameModel.addLog(currentPlayerName, "kocht " + tileName + " voor €"+ cost + "!");
                } else {
                    gameModel.addLog(currentPlayerName, "kocht " + tileName +  " niet.");
                }
            } else {
            gameModel.addLog(currentPlayerName, "heeft niet genoeg geld om\n" + tileName + " te kopen");
            }
        });
    }
}