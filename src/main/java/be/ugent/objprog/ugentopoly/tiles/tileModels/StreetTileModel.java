package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.TilePurchaseAlert;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.StreetCard;
import javafx.collections.ObservableList;

import java.util.function.Consumer;

public class StreetTileModel extends BuyableModel {

    private final String area;
    private final String rent;
    private final String color;

    public StreetTileModel(
            String tileID,
            int tilePosition,
            String color,
            String area,
            int cost,
            String rent,
            DisplayCardController controller
            ) {
        super(tileID, tilePosition, controller, cost);
        this.color = color;
        this.area = area;
        this.rent = rent;
        setCard(new StreetCard(this));
    }

    public String getColor() {
        return color;
    }

    public String getRent() {
        return rent;
    }

    public String getArea() {
        return area;
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
                    int rentAmount = Integer.parseInt(rent);
                    currentPlayer.changeBalance(-rentAmount);
                    owner.changeBalance(rentAmount);
                    gameModel.addLog(currentPlayer.getName(), "betaalt €" + rent + " huur aan " + owner.getName());
                }
            }
        };
    }
}