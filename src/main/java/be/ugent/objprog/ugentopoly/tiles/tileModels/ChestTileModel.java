package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomImage;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.BasicVerticalCard;
import be.ugent.objprog.ugentopoly.tiles.tileinterface.ImageTile;

import java.util.function.Consumer;

public class ChestTileModel extends TileModel implements ImageTile {

    private final CustomImage image = new CustomImage("chest.png");

    public ChestTileModel(String tileID, int tilePosition) {
        super(tileID, tilePosition);
        setCard(new BasicVerticalCard(image, name));
    }

    // TODO make a superclass
    @Override
    public Consumer<GameModel> getPlayerTileInteraction() {
        return (((gameModel) -> {
            PlayerModel playerModel = gameModel.getCurrentPlayer();
            gameModel.addLog(playerModel.getName(), "trekt een algmeen fonds kaart!");
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

    public CustomImage getImage() {
        return image;
    }
}