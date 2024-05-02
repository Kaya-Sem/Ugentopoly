package be.ugent.objprog.ugentopoly.gamecards;

import java.util.*;

public class CardDeck {
    private final Deque<GameCard> cards;

    public CardDeck(List<GameCard> initialCards) {
        Collections.shuffle(initialCards);
        cards = new ArrayDeque<>(initialCards);
    }

    public GameCard getNextCard() {
        GameCard nextCard = cards.removeFirst();
        cards.addLast(nextCard);
        return nextCard;
    }

}