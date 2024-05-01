package be.ugent.objprog.ugentopoly;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomObservable implements Observable {

    // prevent instatiation. Abstract would not make any sense because it has no have no abstract methods. TODO
    protected CustomObservable(){}

    protected final List<InvalidationListener> listenerList = new ArrayList<>();

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
        fireInvalidationEvent();
    }

    protected void fireInvalidationEvent() {
        listenerList.forEach(listener -> {
            try {
                listener.invalidated(this);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        });
    }

    public List<InvalidationListener> getListenerList() {
        return Collections.unmodifiableList(listenerList);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.remove(listener);
    }

}