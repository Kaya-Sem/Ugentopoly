package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.dice.DiceModel;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
NON-URGENT write class documentation
Functions as the controller for GameModel, so performs all the updates for it
 */

public class GameController {
    private final Stage primaryStage;
    private final GameModel gameModel;

    public GameController(Stage primaryStage, GameModel gameModel, DiceModel diceModel) {
        this.primaryStage = primaryStage;
        this.gameModel = gameModel;
        diceModel.setGameController(this);

        initializeGame();
    }

    private void initializeGame() {
        List<PlayerModel> players = gameModel.getPlayerModels();
        players.forEach(this::gameOverCondition);
        gameModel.setCurrentPlayerMove(players.getFirst());

        TileModel startTile = gameModel.getTileModels()[0];
        players.forEach(player -> startTile.addPion(player.getPion()));

        gameModel.addLog(gameModel.getCurrentPlayerMove().getName(), "zal als eerste spelen!");
    }

    // TODO
    public void nextMove()  {
        DiceModel diceModel = gameModel.getDiceModel();
        diceModel.setDisabled(true);

        int moves = diceModel.getMostRecentRoll();
        PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

        for (int i = 0; i < moves; i++) {
                movePion(currentPlayer);
        }

        TileModel currentTile = gameModel.getTileModels()[currentPlayer.getPosition()];
        gameModel.addLog(currentPlayer.getName(), "belande op " + PropertyLoader.getLabel(currentTile.getId()));

        // Retrieve the tile's action and execute it
        Consumer<GameModel> action = currentTile.getPlayerTileInteraction();
        action.accept(gameModel);

        nextPlayer();
        gameModel.getDiceModel().setDisabled(true);
    }

    public void nextPlayer() {
        PlayerModel playerModel = gameModel.getPlayerModelQueue().getNextPlayer();
        if (playerModel.isInJail()) {

            if (playerModel.getLeaveJailCards() > 0) {
                gameModel.addLog(playerModel.getName(), "geraakt thuis van de Overpoort");
                playerModel.changeGetOutOfJailCards(-1);
            } else {
                gameModel.addLog(playerModel.getName(), "is stomdronken, en zal dus moeten dobbelen tot deze nuchter is");
                // implement rolling
            }
        }
        gameModel.setCurrentPlayerMove(playerModel);
        gameModel.addLog(playerModel.getName(), "is aan de beurt!");
    }

    private void movePion(PlayerModel model) {
        int position = model.getPosition();
        TileModel[] tileModels = gameModel.getTileModels();

        TileModel currentModel = tileModels[position];
        currentModel.removePion(model.getPion());

        int newPosition = (position + 1) % tileModels.length;

        model.setPosition(newPosition);
        tileModels[newPosition].addPion(model.getPion());
    }

    public void moveCurrentPlayerToPosition(int newPosition) {
        PlayerModel playerModel = gameModel.getCurrentPlayerMove();
        Pion pion = playerModel.getPion();

        TileModel[] tileModels = gameModel.getTileModels();

        tileModels[playerModel.getPosition()].removePion(pion);
        playerModel.setPosition(newPosition);
        tileModels[newPosition].addPion(pion);
    }

    public void moveCurrentPlayerToJail() {
        moveCurrentPlayerToPosition(10);
    }

    public void addLog(String text) {
        gameModel.addLog(text);
    }

    private void gameOverCondition(PlayerModel model) {
        model.balanceProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if (0 >= newValue.intValue()) {
                        showGameOverDialog(model, gameModel.getPlayerModels());
                        primaryStage.close();
                    }
                }
        );
    }

    // extract to own alert
    private void showGameOverDialog(PlayerModel loser, List<PlayerModel> allPlayers) {
        // Filter out the losing player and sort remaining players by balance in descending order
        List<PlayerModel> sortedPlayers = allPlayers.stream()
                .filter(player -> !player.equals(loser))
                .sorted(Comparator.comparing(PlayerModel::getBalance, Comparator.reverseOrder()))
                .toList();        // Building the ranking message

        StringBuilder rankingMessage = new StringBuilder();
        rankingMessage.append("You have lost the game!\n\n");
        rankingMessage.append("Rankings:\n");
        int rank = 1;
        for (PlayerModel player : sortedPlayers) {
            rankingMessage.append(rank).append(". ")
                    .append(player.getName()).append(" - $")
                    .append(player.getBalance()).append("\n");
            rank++;
        }

        // Create and display the alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over!");
        alert.setContentText(rankingMessage.toString());
        alert.showAndWait();
    }


    public GameModel getGameModel() {
        return gameModel;
    }

}