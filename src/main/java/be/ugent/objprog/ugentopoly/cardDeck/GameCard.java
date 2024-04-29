package be.ugent.objprog.ugentopoly.cardDeck;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.VerticalCard;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GameCard extends VerticalCard {
    private Consumer<GameModel> cardAction = null;

    public void setCardAction(Consumer<GameModel> consumer) {
        cardAction = consumer;
    }

    public Consumer<GameModel> getCardAction() {
        return cardAction;
    }

    public void performAction(GameModel model) {
        cardAction.accept(model);
    }

}