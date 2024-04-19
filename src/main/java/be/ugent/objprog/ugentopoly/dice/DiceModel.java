package be.ugent.objprog.ugentopoly.dice;

import java.util.ArrayList;
import java.util.List;

import be.ugent.objprog.ugentopoly.GameController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.*;

public class DiceModel implements Observable {

    private final List<InvalidationListener> listenerList = new ArrayList<>();
    private GameController controller = null;
    private String mostRecentRoll = "";
    private boolean rollable = true;



    private void fireInvalidationEvent() {
        listenerList.forEach(listener -> listener.invalidated(this));
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    public String getMostRecentRoll() {
        return mostRecentRoll;
    }
    public void setMostRecentRoll(String s) {
        mostRecentRoll = s;
        fireInvalidationEvent();
    }

    public boolean isRollable() {
        return rollable;
    }

    public void setRollable(boolean rollable) {
        this.rollable = rollable;
        fireInvalidationEvent();
    }

    public GameController getController() {
        return controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }
}