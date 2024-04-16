package be.ugent.objprog.ugentopoly.dice;

import java.util.ArrayList;
import java.util.List;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class DiceModel implements Observable {

    private final List<InvalidationListener> listenerList = new ArrayList<>();
    private List<List<Integer>> allThrows = new ArrayList<>();
    private List<Integer> mostRecentRoll = new ArrayList<>();

    public DiceModel() {
    }


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

    public List<Integer> getMostRecentRoll() {
        return mostRecentRoll;
    }

    public void setMostRecentRoll(List<Integer> mostRecentRoll) {
        this.mostRecentRoll = mostRecentRoll;
        fireInvalidationEvent();
    }

    public List<List<Integer>> getAllThrows() {
        return allThrows;
    }

    public void setAllThrows(List<List<Integer>> allThrows) {
        this.allThrows = allThrows;
        fireInvalidationEvent();
    }
}