package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.TilePurchaseAlert;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.StreetCard;
import javafx.collections.ObservableList;

import java.util.function.Consumer;

public class StreetTileModel extends TileModel {

    private PlayerModel owner = null;
    private final String area;
    private final String cost;
    private final String rent;
    private final String color;

    public StreetTileModel(
            String tileID,
            int tilePosition,
            String color,
            String area,
            String cost,
            String rent,
            DisplayCardController controller
            ) {
        super(tileID, tilePosition, controller);
        this.color = color;
        this.area = area;
        this.cost = cost;
        this.rent = rent;
        setCard(new StreetCard(this));
    }

    public PlayerModel getOwner() {
        return owner;
    }

    public void setOwner(PlayerModel owner) {
            this.owner = owner;
            fireInvalidationEvent();
        }

    public String getColor() {
        return color;
    }

    public String getCost() {
        return cost;
    }

    public String getRent() {
        return rent;
    }

    public String getArea() {
        return area;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            String currentPlayerName = currentPlayer.getName();
            ObservableList<TileModel> ownedTiles = currentPlayer.getOwnedTiles();

            if (ownedTiles.contains(this)) {
                gameModel.addLog(currentPlayer.getName(), "landed on his own tile!");
            } else if (null == owner) {
                boolean result = new TilePurchaseAlert(tileName, cost).showAndAwaitResponse();

                if (result) {
                    currentPlayer.changeBalance(-Integer.parseInt(cost));
                    currentPlayer.addBuyable(this);
                    setOwner(currentPlayer);
                    gameModel.addLog(currentPlayerName, "kocht " + tileName + " voor €"+ cost + "!");
                } else {
                    gameModel.addLog(currentPlayerName, "kocht " + tileName +  " niet.");
                }
            } else {
                owner.changeBalance(Integer.parseInt(rent));
                currentPlayer.changeBalance(Integer.parseInt(rent));
                gameModel.addLog(currentPlayer.getName(), "betaald €" + rent + " aan " + owner.getName());
                // TODO add check to see if the owner contains the other areas
            }
        });
    }
}