package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TaxCard;

import java.util.function.Consumer;

public class TaxTileModel extends TileModel{
    private static final CustomImage image = new CustomImage("tax.png");
    private final int amount;

    public TaxTileModel(String tileID, int tilePosition, int amount, DisplayCardController controller) {
        super(tileID, tilePosition, controller);
        this.amount = amount;
        card = (new TaxCard(image, tileName, String.valueOf(amount)));
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (gameModel -> {
            gameModel.changeBonusPot(amount);
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            currentPlayer.changeBalance(-amount);
            gameModel.addLog(currentPlayer.getPlayerName(), "betaald €" + amount);
        });
    }

    public static CustomImage getImage() {
        return image;
    }
}