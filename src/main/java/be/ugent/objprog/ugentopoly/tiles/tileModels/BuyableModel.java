package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.TilePurchaseAlert;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.util.function.Consumer;

public class BuyableModel extends TileModel {

    protected PlayerModel owner = null;
    protected final int cost;
    protected StringProperty ownerName = new SimpleStringProperty(this, "owner", "<geen eigenaar>");

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

    public StringProperty ownerProperty() {
        return ownerName;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            String currentPlayerName = currentPlayer.getName();
            ObservableList<TileModel> ownedTiles = currentPlayer.getOwnedTiles();

            if (ownedTiles.contains(this)) {
                gameModel.addLog(currentPlayer.getName(), "belandt op eigen tegel");
                return;
            }

            if (owner == null) {
                if (currentPlayer.getBalance() < cost) {
                    gameModel.addLog(currentPlayerName, "heeft te weinig geld om deze tile te kopen");
                    return;
                }

                boolean wasBought = new TilePurchaseAlert(name, String.valueOf(cost), card).wasBought();

                if (wasBought) {
                    currentPlayer.changeBalance(-cost);
                    currentPlayer.addBuyable(this);
                    setOwner(currentPlayer);
                    ownerName.set(currentPlayerName);
                    gameModel.addLog(currentPlayerName, "kocht " + name + " voor €"+ cost + "!");
                } else {
                    gameModel.addLog(currentPlayerName, "kocht " + name +  " niet.");
                }
            }
        };
    }
}