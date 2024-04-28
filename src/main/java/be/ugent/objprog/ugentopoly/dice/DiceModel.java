package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.GameController;

public class DiceModel extends CustomObservable {

    private GameController controller = null;
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

    public GameController getController() {
        return controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
        fireInvalidationEvent();
    }
}