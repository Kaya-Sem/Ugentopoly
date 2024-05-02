package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.UtilityCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;
import javafx.collections.ObservableList;

import java.util.Set;
import java.util.function.Consumer;

public class UtilityTileModel extends BuyableModel implements ImageTile {

    private final CustomImage image;

    public UtilityTileModel(String tileID, int tilePosition, int cost) {
        super(tileID, tilePosition, cost);
        image = new CustomImage(id.substring(5) + ".png"); // not robust
        setCard(new UtilityCard(this));
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        Consumer<GameModel> parentInteraction = super.getPlayerTileInteraction();

        return gameModel -> {
            // Execute the parent interaction first
            parentInteraction.accept(gameModel);
            if (owner != null) {
                PlayerModel currentPlayer = gameModel.getCurrentPlayer();

                if (!owner.equals(currentPlayer)) {
                    int amount = calculatePrice(gameModel.getLastRoll(), currentPlayer.getOwnedTiles());
                    currentPlayer.changeBalance(-amount);
                    owner.changeBalance(amount);
                    gameModel.addLog(currentPlayer.getName(), "betaalt €" + amount + " huur aan " + owner.getName());
                }
            }
        };
    }

    // TODO test
    private static int calculatePrice(int aantalOgen, ObservableList<TileModel> tileModels) {
        Set<String> requiredIds = Set.of("tile.utility1", "tile.utility2");

        long countOfUtilities = tileModels.stream()
                .filter(tileModel -> requiredIds.contains(tileModel.getId()))
                .count();

        return (countOfUtilities == 2) ? aantalOgen * 10 : aantalOgen << 2;
    }

    @Override
    public CustomImage getImage() {
        return image;
    }
}