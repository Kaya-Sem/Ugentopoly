package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.players.Pion;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileModel implements Observable {

    private final String id;
    private final int position;
    private final List<Pion> pionnen = new ArrayList<>();

    private final List<InvalidationListener> listenerList;

    public TileModel(String id, int position){
        this.id = id;
        this.position = position;
        listenerList = new ArrayList<>();
    }

    public void addPion(Pion pion) {
        if (!pionnen.contains(pion)) {
            pionnen.add(pion);
           fireInvalidationEvent();
        }
    }

    public void removePion(Pion pion) {
        if (! pionnen.contains(pion)) {
            pionnen.remove(pion);
            fireInvalidationEvent();
        }
    }

    public List<Pion> getPionnen() {
        return Collections.unmodifiableList(pionnen);
    }

    public String getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
        // NEEDSLOG
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.remove(listener);
        // NEEDSLOG
    }

    protected void fireInvalidationEvent() {
        listenerList.forEach(listener -> listener.invalidated(this));
    }

      public List<InvalidationListener> getListenerList() {
        return Collections.unmodifiableList(listenerList);
    }
}