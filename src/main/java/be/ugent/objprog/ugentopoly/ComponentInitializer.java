package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.factories.GameCardFactory;
import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.gameBoard.BoardModel;
import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.InitializedTilesObject;
import be.ugent.objprog.ugentopoly.tiles.TileInitializer;

import java.util.List;

public class ComponentInitializer {

    private final BoardModel boardModel;
    private final TileFactory tileFactory;
    private final TileInitializer tileInitializer;
    private final InitializedTilesObject initializedTilesObject;
    private final GameCardInitializer gameCardInitializer;
    private final CardDeck chanceCardDeck;
    private final CardDeck chestCardDeck;
    private final GameModel gameModel;

    public ComponentInitializer(XMLParser parser, List<PlayerModel> players) {
        boardModel = new BoardModel();
        DisplayCardController cardController = new DisplayCardController(boardModel);

        tileFactory = new TileFactory(parser.areaColors(), parser.getStartAmount(), cardController);
        tileInitializer = new TileInitializer(parser, tileFactory);
        initializedTilesObject = tileInitializer.TileModelInitializer();

        gameCardInitializer = new GameCardInitializer(parser, new GameCardFactory());

        chanceCardDeck = gameCardInitializer.getChanceCards();
        chestCardDeck = gameCardInitializer.getChestCards();

        gameModel = new GameModel(
                players,
                initializedTilesObject.tileModelArray(),
                chanceCardDeck,
                chestCardDeck
        );
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public TileFactory getTileFactory() {
        return tileFactory;
    }

    public TileInitializer getTileInitializer() {
        return tileInitializer;
    }

    public InitializedTilesObject getInitializedTilesObject() {
        return initializedTilesObject;
    }

    public GameCardInitializer getGameCardInitializer() {
        return gameCardInitializer;
    }

    public CardDeck getChanceCardDeck() {
        return chanceCardDeck;
    }

    public CardDeck getChestCardDeck() {
        return chestCardDeck;
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}