package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.TilePurchaseAlert;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.SmallTileView;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.function.Consumer;

public class RailwayTileModel extends TileModel{

    private final int cost;
    private final int rent;
    private PlayerModel owner;
    private static final CustomImage image = new CustomImage("railway.png");

    public RailwayTileModel(String id, int position, int cost, int rent, DisplayCardController controller) {
        super(id, position, controller);
        this.cost = cost;
        this.rent = rent;
        card = new RailwayCard(
                image,
                tileName,
                String.valueOf(cost),
                String.valueOf(rent));
    }

    public int getRent() {
        return rent;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            String currentPlayerName = currentPlayer.getPlayerName();
            ObservableList<TileModel> ownedTiles = currentPlayer.getOwnedTiles();

         if (ownedTiles.contains(this)) {
             gameModel.addLog(currentPlayer.getPlayerName(), "landed on his own tile!");
         } else if (null != owner) {
                gameModel.addLog(currentPlayer.getPlayerName(), "betaalde " + rent + "€ aan" + owner.getPlayerName());
                currentPlayer.changeBalance(-rent);
                owner.changeBalance(rent);
            } else {
                boolean result = new TilePurchaseAlert(
                        PropertyLoader.getLabel(id),
                        String.valueOf(cost)).showAndAwaitResponse();

                if (result) {
                    currentPlayer.changeBalance(-cost);
                    currentPlayer.addTile(this);
                    setOwner(currentPlayer);
                    gameModel.addLog(currentPlayerName, "kocht " + PropertyLoader.getLabel(id) + "!");

                } else {
                    gameModel.addLog(currentPlayerName, "kocht" + PropertyLoader.getLabel(id) +  " niet.");
                }
            }
        };
    }

    public PlayerModel getOwner() {
        return owner;
    }

    public void setOwner(PlayerModel owner) {
        this.owner = owner;
    }

    public CustomImage getImage() {
        return image;
    }
}