package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.TilePurchaseAlert;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.UtilityCard;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Set;
import java.util.function.Consumer;

public class UtilityTileModel extends BuyableModel{

    private final Image image;

    public UtilityTileModel(String tileID, int tilePosition, int cost, DisplayCardController controller) {
        super(tileID, tilePosition, controller, cost);
        image = new CustomImage(id.substring(5) + ".png"); // not robust
        setCard(new UtilityCard(image, String.valueOf(cost)));
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        Consumer<GameModel> parentInteraction = super.getPlayerTileInteraction();

        return gameModel -> {
            // Execute the parent interaction first
            parentInteraction.accept(gameModel);
            if (null != owner) {
                PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

                if (!owner.equals(currentPlayer)) {
                    int amount = calculatePrice(gameModel.getDiceModel().getMostRecentRoll(), currentPlayer.getOwnedTiles());
                    currentPlayer.changeBalance(-amount);
                    owner.changeBalance(amount);
                    gameModel.addLog(currentPlayer.getName(), "betaalt €" + amount + " huur aan " + owner.getName());
                }
            }
        };
    }

    private static int calculatePrice(int aantalOgen, ObservableList<TileModel> tileModels) {
        Set<String> requiredIds = Set.of("tile.utility1", "tile.utility2");

        long countOfUtilities = tileModels.stream()
                .filter(tileModel -> requiredIds.contains(tileModel.getId()))  // Correctly get the ID from each TileModel
                .count();

        return (2 == countOfUtilities) ? aantalOgen * 10 : aantalOgen << 2;
    }

    public Image getImage() {
        return image;
    }
}