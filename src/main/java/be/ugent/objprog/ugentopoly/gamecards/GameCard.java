package be.ugent.objprog.ugentopoly.gamecards;

import be.ugent.objprog.ugentopoly.GameModel;

import java.util.function.Consumer;

public class GameCard {
    private Consumer<GameModel> cardAction = null;
    private final String type;

    public GameCard(String type) {
        this.type = type;
    }

    public void setCardAction(Consumer<GameModel> consumer) {
        cardAction = consumer;
    }

    public Consumer<GameModel> getCardAction() {
        return cardAction;
    }

    public void performAction(GameModel model) {
        cardAction.accept(model);
    }

    public String getType() {
        return type;
    }
}