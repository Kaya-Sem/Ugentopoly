package be.ugent.objprog.ugentopoly.factories;

import be.ugent.objprog.ugentopoly.GameController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.gameBoard.BoardModel;
import be.ugent.objprog.ugentopoly.gamecards.GameCardAlert;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class GameCardFactory<T> {
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

    private static String getAlertMessage(String id) {
        return PropertyFactory.getString(id);
    }

    private static Consumer<GameModel> jail(Map<String, String> data) {
        String alertMessage = getAlertMessage(data.get("id"));

        return (gameModel) -> {
                PlayerModel player = gameModel.getCurrentPlayerMove();
                player.changeGetOutOfJailCards(1);
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();
            gameModel.addLog(player.getName(), "kreeg een get out of jail kaart");
            };
    }

    private static Consumer<GameModel> move(Map<String, String> data) {
        String message = getAlertMessage(data.get("id"));

        int newPosition = Integer.parseInt(data.get("position"));
        boolean collect = Boolean.parseBoolean(data.get("collect"));

        return ((gameModel) -> {
            GameCardAlert alert = new GameCardAlert(message);
            alert.showAndWait();

            GameController controller = gameModel.getGameController();

            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

            controller.moveCurrentPlayerToPosition(newPosition);

            TileModel currentTileModel = gameModel.getTileModels()[newPosition];

            // if it would pass start, call start tile's action
            if ((BoardModel.TOTALTILES <= (newPosition + currentPlayer.getPosition())) && collect) {
                Consumer<GameModel> action = gameModel.getTileModels()[0].getPlayerTileInteraction();
                action.accept(gameModel);
            }

            gameModel.addLog(currentPlayer.getName(), "moet naar " + currentTileModel.getTileName());

            Consumer<GameModel> action = currentTileModel.getPlayerTileInteraction();
            action.accept(gameModel);
        });
    }

    private static Consumer<GameModel> moveRel(Map<String, String> data) {
        int relPosition = Integer.parseInt(data.get("relative"));
        String alertMessage = getAlertMessage(data.get("id"));

        return ((gameModel) -> {
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();

            GameController controller = gameModel.getGameController();

            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

            int newPosition = currentPlayer.getPosition() + relPosition;

            controller.moveCurrentPlayerToPosition(newPosition);

            TileModel currentTile = gameModel.getTileModels()[newPosition];


            String message = (0 < relPosition) ?
                    "zet " + relPosition + " stappen voorwaarts" :
                    "moest " + Math.abs(relPosition) + " stappen naar achter";

            Consumer<GameModel> action = currentTile.getPlayerTileInteraction();
            action.accept(gameModel);
        });
    }

    private static Consumer<GameModel> money(Map<String, String> data) {
        int amount = Integer.parseInt(data.get("amount"));
        String alertMessage = getAlertMessage(data.get("id"));

        return (gameModel) -> {
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();

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
        String alertMessage = getAlertMessage(data.get("id"));

        return (gameModel -> {
            GameCardAlert alert = new GameCardAlert(alertMessage);
            alert.showAndWait();

            PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();
            List<PlayerModel> playerModelList = gameModel.getPlayerModels();

            // add a transfer method?
            playerModelList.forEach(player -> {
                player.changeBalance(-amount);
                currentPlayer.changeBalance(amount);
            });

            gameModel.addLog(currentPlayer.getName(), "kreeg €" + amount + " van elke speler");
        });
    }

}