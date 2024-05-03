package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.GameController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.gamecards.GameCardAlert;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * GameCardFactory utilizes a Map<String, String> to receive tile data, enhancing modularity and abstraction.
 * This design choice allows the factory to be agnostic of the data source, ensuring easy integration
 * and future modifications where the source of data might change (for example from XML to JSON or a database). Using a map
 * as the intermediary data format simplifies the interaction between data parsing and tile creation, maintaining clear
 * separation of concerns and improving the adaptability of the codebase.
 */

public class GameCardFactory<T> {
    private final Map<String, Function<Map<String, String>, Consumer<GameModel>>> actionMap;
    private static final int TILES = 40;

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

        GameCard card = new GameCard(cardType);
        card.setCardAction(action);

        return card;
    }

    private static String getAlertMessage(String id) {
        return PropertyFactory.getString(id);
    }

    private static Consumer<GameModel> jail(Map<String, String> data) {
        String alertMessage = getAlertMessage(data.get("id"));

        return gameModel -> {
                PlayerModel player = gameModel.getCurrentPlayer();
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();
            gameModel.addLog(player.getName(), "kreeg een get out of jail kaart");
            };
    }

    private static Consumer<GameModel> move(Map<String, String> data) {
        String message = getAlertMessage(data.get("id"));
        int newPosition = Integer.parseInt(data.get("position"));
        boolean collect = Boolean.parseBoolean(data.get("collect"));

        return gameModel -> {
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            TileModel currentTileModel = gameModel.getTileModels()[newPosition];
            gameModel.addLog(currentPlayer.getName(), "moet naar " + currentTileModel.getName());

            GameCardAlert alert = new GameCardAlert(message);
            alert.showAndWait();

            // if it would pass start, call start tile's action
            if (newPosition < currentPlayer.getPosition() && collect) {
                Consumer<GameModel> action = gameModel.getTileModels()[0].getPlayerTileInteraction();
                action.accept(gameModel);
            }

            gameModel.getGameController().moveCurrentPlayerToPosition(newPosition);
        };
    }

    private static Consumer<GameModel> moveRel(Map<String, String> data) {
        int relPosition = Integer.parseInt(data.get("relative"));
        String alertMessage = getAlertMessage(data.get("id"));

        return gameModel -> {
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();

            GameController controller = gameModel.getGameController();
            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            TileModel[] tileModels = gameModel.getTileModels();

            // handle negative position situations
            int newPosition = (currentPlayer.getPosition() + relPosition + TILES) % TILES;

            String message = (relPosition > 0) ?
                    "zet " + relPosition + " stappen voorwaarts\nen beland op " + tileModels[newPosition].getName() :
                    "moest " + Math.abs(relPosition) + " stappen naar achter\n" +
                            "om op " + tileModels[newPosition].getName() + " terecht te komen";

            gameModel.addLog(currentPlayer.getName(), message);

            controller.moveCurrentPlayerToPosition(newPosition);
        };
    }

    private static Consumer<GameModel> money(Map<String, String> data) {
        int amount = Integer.parseInt(data.get("amount"));
        String alertMessage = getAlertMessage(data.get("id"));

        return gameModel -> {
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();

            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            currentPlayer.changeBalance(amount);

            String message;
            if (amount > 0) {
                message = "kreeg  €" + amount;
            } else {
                message = "moest €" + Math.abs(amount) + " aan de bonuspot betalen";
                gameModel.changeBonusPot(amount);
            }

            gameModel.addLog(currentPlayer.getName(), message);
        };
    }

    private static Consumer<GameModel> playersMoney(Map<String, String> data) {
        int amount = Integer.parseInt(data.get("amount"));
        String alertMessage = getAlertMessage(data.get("id"));

        return gameModel -> {
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();

            PlayerModel currentPlayer = gameModel.getCurrentPlayer();
            List<PlayerModel> playerModelList = gameModel.getPlayerModels();

            playerModelList.forEach(player -> {
                player.changeBalance(-amount);
                currentPlayer.changeBalance(amount);
            });

            gameModel.addLog(currentPlayer.getName(), "kreeg €" + amount + " van elke speler");
        };
    }

}