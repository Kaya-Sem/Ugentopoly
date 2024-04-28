package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.cardDeck.GameCard;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileViews.ChestTileView;
import javafx.scene.image.Image;

import java.util.Objects;
import java.util.function.Consumer;

public class ChestTileModel extends TileModel{

    private final CustomImage image = new CustomImage("chest.png");

    public ChestTileModel(String tileID, int tilePosition, DisplayCardController controller) {
        super(tileID, tilePosition, controller);
        card = new BasicVerticalCard(image, tileName);
        // HACK let the superclass create the card?
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (((gameModel) -> {
            gameModel.addLog(gameModel.getCurrentPlayerMove().getPlayerName(), "trekt een algemeen fonds kaart!");
            GameCard gameCard = (GameCard) gameModel.getChestCardDeck().getNextCard();
            gameCard.performAction(gameModel,gameCard);
            // TODO raise alert
        }));
    }

    public CustomImage getImage() {
        return image;
    }
}