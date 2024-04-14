package be.ugent.objprog.ugentopoly.players;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel implements Observable {

    private final List<InvalidationListener> listenerList;

    private String playerName;
    private int balance;
    private final String color;

    // TODO list of owned tiles. need to implement MVC for tiles and have TileModels


    public  PlayerModel(String playerName, String color) {
        this.listenerList = new ArrayList<>();
        this.playerName = playerName;
        this.color = color;
        this.balance = 0; // TODO what is the starting balance? -> see xml
        // LOG player tileModel instantiated {player date}
    }

    private void fireInvalidationEvent() {
        for (InvalidationListener listener : listenerList) {
            listener.invalidated(this);
        }
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        fireInvalidationEvent();
    }

    public int getBalance() {return balance;}

    public void setBalance(int balance) {
        if (balance != 0) {
            this.balance = balance;
            fireInvalidationEvent();
        }
    }

    public String getColor() {return color;}

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.add(listener);
    }
}