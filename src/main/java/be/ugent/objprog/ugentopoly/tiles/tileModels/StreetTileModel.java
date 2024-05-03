package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.StreetCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ColorTile;

import java.util.Arrays;
import java.util.function.Consumer;

public class StreetTileModel extends BuyableModel  implements ColorTile {

    private final String area;
    private final String rent;
    private final String color;


    public StreetTileModel(
            String tileID,
            int tilePosition,
            String color,
            String area,
            int cost,
            String rent
            ) {
        super(tileID, tilePosition, cost);
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

            PlayerModel currentPlayer = gameModel.getCurrentPlayer();

            if (owner != null && !owner.equals(currentPlayer)) {

                // Check if the owner owns all tiles in the same area (not very efficient)
                boolean ownsAll = Arrays.stream(gameModel.getTileModels()).toList().stream()
                        .filter(tile -> tile instanceof StreetTileModel)
                        .map(tile -> (StreetTileModel) tile)
                        .filter(streetTile -> area.equals(streetTile.area))
                        .allMatch(streetTile -> streetTile.getOwner() != null && streetTile.getOwner().equals(owner));

                int rentAmount = Integer.parseInt(rent);
                if (ownsAll) {
                    rentAmount *= 2; // Double the rent if the owner owns all tiles in the area
                    gameModel.addLog(owner.getName(), "bezit alle eigendommen in " + area + ", huur is verdubbeld.");
                }

                currentPlayer.changeBalance(-rentAmount);
                owner.changeBalance(rentAmount);
                gameModel.addLog(currentPlayer.getName(), "betaalt €" + rentAmount + " huur aan " + owner.getName());
            }
        };
    }
}