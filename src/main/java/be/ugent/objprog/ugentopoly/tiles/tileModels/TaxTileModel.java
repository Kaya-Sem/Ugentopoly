package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TaxCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;

import java.util.function.Consumer;

public class TaxTileModel extends TileModel implements ImageTile {
    private static final CustomImage image = new CustomImage("tax.png");
    private final int amount;

    public TaxTileModel(String tileID, int tilePosition, int amount) {
        super(tileID, tilePosition);
        this.amount = amount;
        setCard(new TaxCard(image, tileName, String.valueOf(amount)));
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (gameModel -> {
            gameModel.changeBonusPot(amount);
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            currentPlayer.changeBalance(-amount);
            gameModel.addLog(currentPlayer.getName(), "betaald €" + amount);
        });
    }

    @Override
    public CustomImage getImage() {
        return image;
    }
}