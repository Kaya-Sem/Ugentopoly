package be.ugent.objprog.ugentopoly.cardDeck;

import be.ugent.objprog.ugentopoly.tiles.tileCards.VerticalCard;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private final List<GameCard> cards;

    public CardDeck(List<GameCard> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public VerticalCard getNextCard() {
        GameCard nextCard = cards.removeFirst();
        cards.add(nextCard);
        return nextCard;
    }

}