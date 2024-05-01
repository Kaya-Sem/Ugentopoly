package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.dice.DiceRoller;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.stage.Stage;

import java.util.List;
import java.util.function.Consumer;

/*
NON-URGENT write class documentation
Functions as the controller for GameModel, so performs all the updates for it
 */

public class GameController {
    private final Stage primaryStage;
    private final GameModel gameModel;
    private final DiceRoller diceRoller;

    public GameController(Stage primaryStage, GameModel gameModel) {
        this.primaryStage = primaryStage;
        this.gameModel = gameModel;
        diceRoller = new DiceRoller(this);

        initializeGame();
    }

    private void initializeGame() {
        List<PlayerModel> players = gameModel.getPlayerModels();
        players.forEach(this::applygGameOverCondition);
        gameModel.setCurrentPlayer(players.getFirst());

        TileModel startTile = gameModel.getTileModels()[0];
        players.forEach(player -> startTile.addPion(player.getPion()));

        gameModel.addLog(gameModel.getCurrentPlayer().getName(), "zal als eerste spelen!");
    }

    // TODO
    public void nextMove()  {
        diceRoller.setIsDisabled(Boolean.TRUE);

        int moves = diceRoller.getMostRecentRoll();
        PlayerModel currentPlayer = gameModel.getCurrentPlayer();

        for (int i = 0; i < moves; i++) {
                movePion(currentPlayer);
        }

        TileModel currentTile = gameModel.getTileModels()[currentPlayer.getPosition()];
        gameModel.addLog(currentPlayer.getName(), "belande op " + currentTile.getName() );

        currentTile.executePlayerTileInteraction(gameModel);

        diceRoller.setIsDisabled(Boolean.TRUE);

        gameModel.getPlayerModels().forEach(PlayerModel::updateBalanceHistory);

        nextPlayer();
    }

    public void nextPlayer() {
        PlayerModel playerModel = gameModel.getPlayerModelQueue().getNextPlayer();
        gameModel.setCurrentPlayer(playerModel);
        gameModel.addLog(playerModel.getName(), "is aan de beurt!");

        if (playerModel.isInJail()) {
            if (playerModel.getLeaveJailCards() > 0) {
                gameModel.addLog(playerModel.getName(), "gebruikt een get-out-of-jail kaart\nen geraakt thuis van de Overpoort");
                playerModel.changeGetOutOfJailCards(-1);
            } else {
                gameModel.addLog(playerModel.getName(), "is stomdronken, en zal dus moeten\ndobbelen tot deze nuchter is");
                diceRoller.rollToGetFree();
            }
        }
    }

    private void movePion(PlayerModel model) {
        int position = model.getPosition();
        TileModel[] tileModels = gameModel.getTileModels();

        TileModel currentModel = tileModels[position];
        currentModel.removePion(model.getPion());

        int newPosition = (position + 1) % tileModels.length;

        // passing start
        if (newPosition == 0) {
            tileModels[0].getPlayerTileInteraction();
        }

        model.setPosition(newPosition);
        tileModels[newPosition].addPion(model.getPion());
    }

    public void moveCurrentPlayerToPosition(int newPosition) {
        PlayerModel playerModel = gameModel.getCurrentPlayer();
        TileModel[] tileModels = gameModel.getTileModels();

        tileModels[playerModel.getPosition()].removePion(playerModel.getPion());
        playerModel.setPosition(newPosition);
        TileModel finalTile = tileModels[newPosition];
        if (finalTile.getPosition() == 10) {
            playerModel.setInJail(true);
        }
        finalTile.addPion(playerModel.getPion());
    }

    public void freePlayerFromJail(int moves) {
        PlayerModel freePlayer = gameModel.getCurrentPlayer();
        freePlayer.setInJail(false);
        gameModel.addLog(freePlayer.getName(), "gooide een dubbel en ontsnapt uit de Overpoort!");
        moveCurrentPlayerToPosition(gameModel.getCurrentPlayer().getPosition() + moves);
    }

    public void moveCurrentPlayerToJail() {
        moveCurrentPlayerToPosition(10);
    }

    public void addLog(String text) {
        gameModel.addLog(text);
    }

    private void applygGameOverCondition(PlayerModel model) {
        model.balanceProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if (newValue.intValue() <= 0) {
                        gameModel.getPlayerModels().forEach(PlayerModel::updateBalanceHistory);
                        GameOverDialog dialog = new GameOverDialog(model, gameModel.getPlayerModels());
                        dialog.show();
                        primaryStage.close();
                    }
                }
        );
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public DiceRoller getDiceRoller() {
        return diceRoller;
    }

}