package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.cardDeck.GameCard;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

// HACK add an alert for each one
public class GameCardFactory<T> {
    protected static final int TILES = 40;
    private final Map<String, Function<Map<String, String>, Consumer<GameModel>>> actionMap;

    public GameCardFactory() {
        actionMap = Map.of(
                "JAIL", GameCardFactory::jail,
                "MOVE", GameCardFactory::move,
                "MOVEREL", GameCardFactory::moveRel,
                "MONEY", GameCardFactory::money,
                "PLAYERS_MONEY", GameCardFactory::playersMoney
        );
    }

    public GameCard forge(Map<String, String> tileData) {
        String cardType = tileData.get("type");
        Consumer<GameModel> action = actionMap.get(cardType).apply(tileData);

        GameCard card = new GameCard();
        card.setCardAction(action);
        return card;
    }

    private static Consumer<GameModel> jail(Map<String, String> data) {
        return (gameModel) -> {
                PlayerModel player = gameModel.getCurrentPlayerMove();
                player.changeGetOutOfJailCards(1);
                // TODO show card via alert
            gameModel.addLog(player.getName(), "kreeg een get out of jail kaart");
            };
    }

    private static Consumer<GameModel> move(Map<String, String> data) {
        int newPosition = Integer.parseInt(data.get("position"));
        boolean collect = Boolean.parseBoolean(data.get("collect"));

        return ((gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            Pion pion = currentPlayer.getPion();
            gameModel.getTileModels()[pion.getPosition()].removePion(pion);

            // TODO utilize gameControllers movePion

            // if it would pass start, call start tile's action
            if ((TILES <= (newPosition + pion.getPosition())) && collect) {
                Consumer<GameModel> action = gameModel.getTileModels()[0].getPlayerTileInteraction();
                action.accept(gameModel);
            }

            pion.setPosition(newPosition);
            gameModel.getTileModels()[newPosition].addPion(pion);

            gameModel.addLog(currentPlayer.getName(), "moved to tile unknown!"); // TODO
        });
    }

    private static Consumer<GameModel> moveRel(Map<String, String> data) {
        int relPosition = Integer.parseInt(data.get("relative"));

        return ((gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

            Pion pion = currentPlayer.getPion();
            gameModel.getTileModels()[pion.getPosition()].removePion(pion);

            pion.setPosition(pion.getPosition() + relPosition);
            gameModel.getTileModels()[pion.getPosition()].addPion(pion);

            String message;

            message = (0 < relPosition) ?
                    "gaat " + relPosition + " stappen voorwaarts" :
                    "moest " + Math.abs(relPosition) + " stappen naar achter";
            gameModel.addLog(currentPlayer.getName(), message);
        });
    }

    private static Consumer<GameModel> money(Map<String, String> data) {
        int amount = Integer.parseInt(data.get("amount"));
        return (gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            currentPlayer.changeBalance(amount);

            String message = (0 < amount) ?
                    ("kreeg  €" + amount) :
                    ("moest €" + Math.abs(amount) + " betalen");

            gameModel.addLog(currentPlayer.getName(), message);
        };
    }

    private static Consumer<GameModel> playersMoney(Map<String, String> data) {
        int amount = Integer.parseInt(data.get("amount"));

        return (((gameModel) -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            List<PlayerModel> playerModelList = gameModel.getPlayerModels();

            // add a transfer method?
            playerModelList.forEach(player -> {
                player.changeBalance(-amount);
                currentPlayer.changeBalance(amount);
            });

            gameModel.addLog(currentPlayer.getName(), "krijgt €" + amount + " van elke speler");
        }));
    }

}