package be.ugent.objprog.ugentopoly.gamecards;

import java.util.*;

public class CardDeck {
    private final Deque<GameCard> cards;

    public CardDeck(List<GameCard> initialCards) {
        Collections.shuffle(initialCards);
        cards = new ArrayDeque<>(initialCards);
    }

    public GameCard getNextCard() {return cards.removeFirst();}

    public void addCard(GameCard card) {
        cards.addLast(card);
    }

    public int getSize() {
        return cards.size();
    }
}