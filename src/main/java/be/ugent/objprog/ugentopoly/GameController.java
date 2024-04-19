package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.dice.DiceModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.Observable;
import javafx.stage.Stage;

import java.util.List;

/*
Functions as the controller for GameModel, so performs all the updates for it

 */

public class GameController {
    private final Stage primaryStage;
    private final GameModel gameModel;
    private final DiceModel diceModel;

    public GameController(Stage primaryStage, GameModel gameModel, DiceModel diceModel) {
        this.primaryStage = primaryStage;
        this.gameModel = gameModel;
        this.diceModel = diceModel;
        this.diceModel.setController(this);

        initializeGame();
    }

    // TODO add nextMove() method to switch to next player

    private void initializeGame() {
        List<PlayerModel> players = gameModel.getPlayerModels();
        players.forEach(this::gameOverCondition);
        gameModel.setCurrentPlayerMove(players.getFirst());

         TileModel startTile = (TileModel) gameModel.getTileModels()[0];

         players.forEach(player -> {
             startTile.addPion(player.getPion());
         });

    }

    private void nextMove() {
        // change current move user to next in line, if they are not in jail. Create a boolean for that? implement a queue?
        // allow them to roll

        // according to outcome, disable the button or allow them to move again

        // moves according to outcome -> update step by step tile position (fade in/fade out)?
        // perform a call to a method to perform a tile's action.
        // execute that action
        // repeat
    }

        public void rollDice(List<Integer> list) {
        diceModel.setRollable(false);
        diceModel.setMostRecentRoll(String.valueOf(list.getFirst() + list.getLast()));

        if (list.getFirst().equals(list.getLast())) {
            diceModel.setRollable(true);
            return;
        }

        // perform move


            // next move
        diceModel.setRollable(true);
    }

    private void gameOverCondition(PlayerModel model) {
        model.balanceProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if (newValue.intValue() <= 0) {
                        System.out.println("Player " + model.getPlayerName() + " is bankrupt!");
                        primaryStage.close();
                        // TODO add closing window / dialog popup
                    }
                }
        );
    }

    public GameModel getGameModel() {
        return gameModel;
    }
    public DiceModel getDiceModel() {
        return diceModel;
    }
}