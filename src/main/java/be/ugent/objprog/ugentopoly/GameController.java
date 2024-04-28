package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.cardDeck.GameCard;
import be.ugent.objprog.ugentopoly.dice.DiceModel;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.stage.Stage;

import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;
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
        diceModel.setController(this);

        initializeGame();
    }

    private void initializeGame() {
        List<PlayerModel> players = gameModel.getPlayerModels();
        players.forEach(this::gameOverCondition);
        gameModel.setCurrentPlayerMove(players.getFirst());

        TileModel startTile = gameModel.getTileModels()[0];
        players.forEach(player -> {
            Pion pion = player.getPion();
            pion.setPosition(0);
            startTile.addPion(pion);
        });
        gameModel.addLog(gameModel.getCurrentPlayerMove().getPlayerName(), "zal als eerste spelen!");
    }

    // TODO
    public void nextMove()  {
        int moves = gameModel.getDiceModel().getMostRecentRoll();
        PlayerModel currentPlayer = gameModel.getCurrentPlayerMove();

        Pion currentPion = currentPlayer.getPion();

        for (int i = 0; i < moves; i++) {
                movePion(currentPion);
        }

        TileModel currentTile = gameModel.getTileModels()[currentPion.getPosition()];
        gameModel.addLog(currentPlayer.getPlayerName(), "belande op " + PropertyLoader.getLabel(currentTile.getId()));
        Consumer<GameModel> action = currentTile.getPlayerTileInteraction();
        action.accept(gameModel);

        nextPlayer();
    }

    private void nextPlayer() {
        PlayerModel playerModel = gameModel.getPlayerModelQueue().getNextPlayer();
        if (playerModel.isInJail()) {

            if (playerModel.getLeaveJailCards() > 0) {
                gameModel.addLog(playerModel.getPlayerName(), "geraakt thuis van de Overpoort");
                playerModel.changeGetOutOfJailCards(-1);
            } else {
                gameModel.addLog(playerModel.getPlayerName(), "is stomdronken, en zal dus moeten dobbelen tot deze nuchter is");
                // implement rolling
            }
        }
        gameModel.setCurrentPlayerMove(playerModel);
        gameModel.addLog(playerModel.getPlayerName(), "is aan de beurt!");
    }

    private void movePion(Pion pion) {
        int position = pion.getPosition();
        TileModel[] tileModels = gameModel.getTileModels();

        TileModel currentModel = tileModels[position];
        currentModel.removePion(pion);

        int newPosition = (position + 1) % tileModels.length;

        pion.setPosition(newPosition);

        TileModel newModel = tileModels[newPosition];
        newModel.addPion(pion);
    }

    // HACK to fix.
    private void gameOverCondition(PlayerModel model) {
    /*    model.balanceProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if (0 >= newValue.intValue()) {
                        primaryStage.close();
                        // TODO add closing window / dialog popup
                    }
                }
        );*/
    }

    public GameModel getGameModel() {
        return gameModel;
    }

}