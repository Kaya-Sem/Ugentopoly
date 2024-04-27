package be.ugent.objprog.ugentopoly.cardDeck;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.VerticalCard;

import java.util.function.BiConsumer;

public class GameCard extends VerticalCard {
    private BiConsumer<GameModel, GameCard> cardAction;
    // Kanskaart heeft een BiConsumer? neemt een playermodel en een card.
    // de biconsumer bepaalt een bepaalde actie die moet gebeuren, met

    public GameCard() {
        cardAction = (gameModel, chanceCard) -> {
            gameModel.addLog(gameModel.getCurrentPlayerMove().getPlayerName(), " landed on a tile with no action");
        };
    }

    public void setCardAction(BiConsumer<GameModel, GameCard> consumer) {
        cardAction = consumer;
    }

    public void performAction(GameModel model, GameCard gameCard) {
        cardAction.accept(model, gameCard);
    }

}