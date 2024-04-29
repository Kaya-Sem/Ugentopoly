package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.GameController;

public class DiceModel extends CustomObservable {

    private GameController gameController = null;
    private int mostRecentRoll = 0;
    private boolean disabled = false;

    public int getMostRecentRoll() {
        return mostRecentRoll;
    }

    public void setMostRecentRoll(int roll) {
        mostRecentRoll = roll;
        fireInvalidationEvent();
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
        fireInvalidationEvent();
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        fireInvalidationEvent();
    }
}