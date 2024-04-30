package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.TilePurchaseAlert;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.UtilityCard;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Set;
import java.util.function.Consumer;

public class UtilityTileModel extends TileModel{

    private PlayerModel owner = null;
    private final int cost;

    private final Image image;

    public UtilityTileModel(String tileID, int tilePosition, int cost, DisplayCardController controller) {
        super(tileID, tilePosition, controller);
        this.cost = cost;
        image = new CustomImage(id.substring(5) + ".png");
        setCard(new UtilityCard(image, String.valueOf(cost)));
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
                gameModel.addLog(currentPlayer.getName(), "landed on his own tile!");
            } else if (null == owner) {
                boolean result = new TilePurchaseAlert(tileName, String.valueOf(cost)).showAndAwaitResponse();

                if (result) {
                    currentPlayer.changeBalance(-cost);
                    currentPlayer.addBuyable(this);
                    owner = currentPlayer;
                    gameModel.addLog(currentPlayerName, "kocht " + tileName + " voor €"+ cost + "!");
                } else {
                    gameModel.addLog(currentPlayerName, "kocht " + tileName +  " niet.");
                }
            } else {
                int price = calculatePrice(gameModel.getDiceModel().getMostRecentRoll(), ownedTiles);
                owner.changeBalance(price);
                currentPlayer.changeBalance(price);
                gameModel.addLog(currentPlayer.getName(), "payed " + owner.getName() + " " + price + " euro rent");
            }

        });
    }

    private static int calculatePrice(int aantalOgen, ObservableList<TileModel> tileModels) {
        Set<String> requiredIds = Set.of("tile.utility1", "tile.utility2");

        long countOfUtilities = tileModels.stream()
                .filter(tileModel -> requiredIds.contains(tileModel.getId()))  // Correctly get the ID from each TileModel
                .count();

        return (2 == countOfUtilities) ? aantalOgen * 10 : aantalOgen << 2;
    }

    public PlayerModel getOwner() {
        return owner;
    }

    public void setOwner(PlayerModel owner) {
        this.owner = owner;
    }

    public Image getImage() {
        return image;
    }
}