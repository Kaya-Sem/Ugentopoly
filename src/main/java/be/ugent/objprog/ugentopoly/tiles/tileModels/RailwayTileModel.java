package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.RailwayCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;

import java.util.function.Consumer;

public class RailwayTileModel extends BuyableModel implements ImageTile {

    private final int rent;
    private static final CustomImage image = new CustomImage("railway.png");

    public RailwayTileModel(String tileID, int tilePosition, int cost, int rent) {
        super(tileID, tilePosition, cost);
        this.rent = rent;
        setCard(new RailwayCard(
                image,
                name,
                String.valueOf(cost),
                String.valueOf(rent)));
    }

    public int getRent() {
        return rent;
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
                    int rentAmount = rent;
                    currentPlayer.changeBalance(-rentAmount);
                    owner.changeBalance(rentAmount);
                    gameModel.addLog(currentPlayer.getName(), "betaalt €" + rent + " huur aan " + owner.getName());
                }
            }
        };
    }

    @Override
    public CustomImage getImage() {
        return image;
    }
}