package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;
import javafx.scene.image.Image;

import java.util.function.Consumer;

public class ChanceTileModel extends TileModel implements ImageTile {
    private final Image image = new CustomImage("chance.png");

    public ChanceTileModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, name));
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (((gameModel) -> {
            PlayerModel playerModel = gameModel.getCurrentPlayer();
            gameModel.addLog(playerModel.getName(), "trekt een kanskaart!");
            CardDeck chanceCardDeck = gameModel.getChanceCardDeck();
            GameCard gameCard = chanceCardDeck.getCard();

            // Players cannot keep non-jail cards
            if ("JAIL".equals(gameCard.getType())) {
                playerModel.addGetOutOfJailCard(gameCard);
            } else {
                chanceCardDeck.addCard(gameCard);
            }

            gameCard.performAction(gameModel);
        }));
    }
}