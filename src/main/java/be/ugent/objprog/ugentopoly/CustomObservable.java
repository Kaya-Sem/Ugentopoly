package be.ugent.objprog.ugentopoly;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CustomObservable implements Observable {

    protected CustomObservable(){}

    protected final List<InvalidationListener> listenerList = new ArrayList<>();

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
        fireInvalidationEvent();
    }

    protected void fireInvalidationEvent() {
        listenerList.forEach(listener -> listener.invalidated(this));
    }

    public List<InvalidationListener> getListenerList() {
        return Collections.unmodifiableList(listenerList);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.remove(listener);
    }

}