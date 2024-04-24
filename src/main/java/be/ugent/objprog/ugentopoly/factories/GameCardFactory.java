package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.cardDeck.GameCard;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

// HACK create interface for the factories?
// HACK add an alert for each one
public class GameCardFactory<T> {
    protected static final int TILES = 40;
    private Map<String, String> data = null;

    private final Map<String, Supplier<BiConsumer<GameModel, GameCard>>> actions = Map.of(
            "JAIL", this::jail,
            "MOVE", this::move,
            "MOVEREL", this::moveRel,
            "MONEY", this::money,
            "PLAYERS_MONEY", this::playersMoney
    );

    public GameCard forge(Map<String, String> tileData) {
        // add id to chancecard
        data = tileData;
        Supplier action = actions.get(tileData.get("type"));
        GameCard card = new GameCard();
        card.setCardAction((BiConsumer<GameModel, GameCard>) action.get());
        return card;
    }

    private BiConsumer<GameModel, GameCard> jail() {
        return (gameModel, chanceCard) -> {
                PlayerModel player = gameModel.getCurrentPlayerMove();
                player.changeGetOutOfJailCards(1);
                // TODO show card via alert
            };
    }

    private BiConsumer<GameModel, GameCard> move() {
        return ((gameModel, chanceCard) -> {
            boolean collect = Boolean.parseBoolean(data.get("collect"));
            int newPosition = Integer.parseInt(data.get("position"));

            Pion pion = gameModel.getCurrentPlayerMove().getPion();
            gameModel.getTileModels()[pion.getPosition()].removePion(pion);

            // if it would pass start, call start tile's action!
            if (TILES < newPosition + pion.getPosition() && collect) {
                Consumer<GameModel> action = gameModel.getTileModels()[0].getPlayerTileInteraction();
                action.accept(gameModel);
            }

            pion.setPosition(newPosition);
            gameModel.getTileModels()[newPosition].addPion(pion);
            // NEEDSLOG
        });
    }

    private BiConsumer<GameModel, GameCard> moveRel() {
        return ((gameModel, chanceCard) -> {
            int relPosition = Integer.parseInt(data.get("relative"));

            Pion pion = gameModel.getCurrentPlayerMove().getPion();
            gameModel.getTileModels()[pion.getPosition()].removePion(pion);

            pion.setPosition(pion.getPosition() + relPosition);
            gameModel.getTileModels()[pion.getPosition()].addPion(pion);
            // NEEDSLOG
        });
    }

    private BiConsumer<GameModel, GameCard> money() {
        return (((gameModel, chanceCard) -> {
            int amount = Integer.parseInt(data.get("amount"));
            gameModel.getCurrentPlayerMove().changeBalance(amount);
        }));
        // NEEDSLOG
    }

    private BiConsumer<GameModel, GameCard> playersMoney() {
        return (((gameModel, chanceCard) -> {
            int amount = Integer.parseInt(data.get("amount"));
            gameModel.getPlayerModels().forEach(player -> player.changeBalance(-amount));
        }));
    }

}