package be.ugent.objprog.ugentopoly.players;

import java.util.ArrayList;
import java.util.List;

import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.paint.Color;

public class PlayerModel implements Observable {

    private final List<InvalidationListener> listenerList;

    private String playerName;
    private int balance;
    private final String color;
    private final String badge;
    private List<? extends Tile> ownedTiles; // TODO implement

    @Override
    public String toString() {
        return "\n" + "Player Name: " + playerName + "\n" +
                "Balance: " + balance + "\n" +
                "Color: " + color + "\n" +
                "Badge: " + badge;
    }

    public PlayerModel(String playerName, Color color, int balance, String badge) {
        listenerList = new ArrayList<>();
        this.playerName = playerName;
        this.color = String.valueOf(color);
        this.balance = balance;
        this.badge = badge;

        // NEEDSLOG
    }

    private void fireInvalidationEvent() {
        listenerList.forEach(listener -> listener.invalidated(this));
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        fireInvalidationEvent();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance != 0) {
            this.balance = balance;
            fireInvalidationEvent();
        }
    }

    public String getColor() {
        return color;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    public String getBadge() {
        return badge;
    }
}
