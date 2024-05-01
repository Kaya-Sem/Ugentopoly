package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;

import java.util.function.Consumer;

public class ChestTileModel extends TileModel implements ImageTile {

    private final CustomImage image = new CustomImage("chest.png");

    public ChestTileModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, name));
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (((gameModel) -> {
            gameModel.addLog(gameModel.getCurrentPlayer().getName(), "trekt een algemeen fonds kaart!");
            GameCard gameCard = gameModel.getChestCardDeck().getNextCard();
            gameCard.performAction(gameModel);
        }));
    }

    public CustomImage getImage() {
        return image;
    }
}