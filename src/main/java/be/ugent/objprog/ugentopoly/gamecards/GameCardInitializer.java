package be.ugent.objprog.ugentopoly.gamecards;

import be.ugent.objprog.ugentopoly.factories.GameCardFactory;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameCardInitializer {

    private final CardDeck chanceCards;
    private final CardDeck chestCards;

    public GameCardInitializer(XMLParser parser, GameCardFactory factory) {
        Map<String, Map<String, String>> chanceCardsMap = parser.getChanceCards();
        Map<String, Map<String, String>> chestCardsMap = parser.getChestCards();

        chanceCards = forgeGameCards(chanceCardsMap, factory);
        chestCards = forgeGameCards(chestCardsMap, factory);
    }

    private static CardDeck forgeGameCards(Map<String, Map<String, String>> cardDataMap, GameCardFactory factory) {
        List<GameCard> cards = new ArrayList<>();
        cardDataMap.values().forEach(cardData -> cards.add(factory.forge(cardData)));

        return new CardDeck(cards);
    }

    public CardDeck getChanceCards() {
        return chanceCards;
    }

    public CardDeck getChestCards() {
        return chestCards;
}
}