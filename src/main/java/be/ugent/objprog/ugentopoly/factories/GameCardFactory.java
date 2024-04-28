package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.cardDeck.GameCard;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

// HACK add an alert for each one
// HACK create the actual card and give the properties with it
public class GameCardFactory<T> {
    protected static final int TILES = 40;
    private Map<String, String> data = null;

    private final Map<String, Supplier<BiConsumer<GameModel, GameCard>>> actions = Map.of(
            "JAIL", GameCardFactory::jail,
            "MOVE", this::move,
            "MOVEREL", this::moveRel,
            "MONEY", this::money,
            "PLAYERS_MONEY", this::playersMoney
    );

    public GameCard forge(Map<String, String> tileData) {
        data = tileData;
        Supplier action = actions.get(tileData.get("type"));
        GameCard card = new GameCard();
        card.setCardAction((BiConsumer<GameModel, GameCard>) action.get());
        return card;
    }

    private static BiConsumer<GameModel, GameCard> jail() {
        return (gameModel, chanceCard) -> {
                PlayerModel player = gameModel.getCurrentPlayerMove();
                player.changeGetOutOfJailCards(1);
                // TODO show card via alert
            gameModel.addLog(player.getPlayerName(), "kreeg een get out of jail kaart");
            };
    }

    private BiConsumer<GameModel, GameCard> move() {
        return ((gameModel, chanceCard) -> {
            boolean collect = Boolean.parseBoolean(data.get("collect"));
            int newPosition = Integer.parseInt(data.get("position"));

            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            Pion pion = currentPlayer.getPion();
            gameModel.getTileModels()[pion.getPosition()].removePion(pion);

            // if it would pass start, call start tile's action
            if (TILES < newPosition + pion.getPosition() && collect) {
                Consumer<GameModel> action = gameModel.getTileModels()[0].getPlayerTileInteraction();
                action.accept(gameModel);
            }

            pion.setPosition(newPosition);
            gameModel.getTileModels()[newPosition].addPion(pion);

            gameModel.addLog(currentPlayer.getPlayerName(), "moved to tile unknown!"); // TODO
        });
    }

    private BiConsumer<GameModel, GameCard> moveRel() {
        return ((gameModel, chanceCard) -> {
            int relPosition = Integer.parseInt(data.get("relative"));

            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

            Pion pion = currentPlayer.getPion();
            gameModel.getTileModels()[pion.getPosition()].removePion(pion);

            pion.setPosition(pion.getPosition() + relPosition);
            gameModel.getTileModels()[pion.getPosition()].addPion(pion);

            String message;

            if (0 < relPosition) {
                message = "gaat " + relPosition + " stappen voorwaarts";
            } else {
                message = "moest " + Math.abs(relPosition) + " stappen naar achter";
            }
            gameModel.addLog(currentPlayer.getPlayerName(), message);
        });
    }

    private BiConsumer<GameModel, GameCard> money() {
        return (((gameModel, chanceCard) -> {
            int amount = Integer.parseInt(data.get("amount"));
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            currentPlayer.changeBalance(amount);
            String message;

            if (0 < amount) {
                message = "received " + amount;
            } else {
                amount = Math.abs(amount);
                message = "moest €" + amount + " betalen";
            }
            gameModel.addLog(currentPlayer.getPlayerName(), message);
        }));
    }

    private BiConsumer<GameModel, GameCard> playersMoney() {
        return (((gameModel, chanceCard) -> {
            int amount = Integer.parseInt(data.get("amount"));
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            List<PlayerModel> playerModelList = gameModel.getPlayerModels();

            // add a transfer method?
            playerModelList.forEach(player -> {
                player.changeBalance(-amount);
                currentPlayer.changeBalance(amount);
            });

            gameModel.addLog(currentPlayer.getPlayerName(), "krijgt " + amount + " van elke speler");
        }));
    }

}