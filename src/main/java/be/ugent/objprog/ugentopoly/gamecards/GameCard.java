package be.ugent.objprog.ugentopoly.gamecards;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.VerticalCard;

import java.util.function.Consumer;

public class GameCard {
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