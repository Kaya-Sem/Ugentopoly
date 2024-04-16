package be.ugent.objprog.ugentopoly.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PlayerModel implements Observable {

    private final List<InvalidationListener> listenerList;

    private final String playerName;
    private int balance;
    private final String color;
    private final Image badgeImage;
    private final String badgeName;
    private final Pion pion;

    private List<TileModel> ownedTiles; // TODO implement

    public PlayerModel(String playerName, Color color, int balance, ImageTextItem badgeImage) {
        listenerList = new ArrayList<>();

        ownedTiles = new ArrayList<>();
        this.playerName = playerName;
        this.color = String.valueOf(color);
        this.balance = balance;
        this.badgeImage = badgeImage.image();
        badgeName = badgeImage.text();
        pion = new Pion(this.badgeImage);

        // NEEDSLOG
    }

    public  void addTile(TileModel tileModel) {
        ownedTiles.add(tileModel);
    }

    public ObservableList<? extends TileModel> getOwnedTiles() {
        return (ObservableList<? extends TileModel>) ownedTiles;
    }

    private void fireInvalidationEvent() {
        listenerList.forEach(listener -> listener.invalidated(this));
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (0 != balance) {
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

    public Image getBadgeImage() {
        return badgeImage;
    }


    public String getBadgeName() {
        return badgeName;
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "listenerList=" + listenerList +
                ", playerName='" + playerName + '\'' +
                ", balance=" + balance +
                ", color='" + color + '\'' +
                ", badgeImage=" + badgeImage +
                ", badgeName='" + badgeName + '\'' +
                ", ownedTiles=" + ownedTiles +
                '}';
    }

    public Pion getPion() {
        return pion;
    }
}