package be.ugent.objprog.ugentopoly.players;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PlayerModel extends CustomObservable {

    private final String playerName;
    private int balance;
    private final Image badgeImage;
    private final String badgeName;
    private final Pion pion;
    private boolean inJail = false;
    private int leaveJailCards = 0;

    private final ObservableList<TileModel> ownedTiles = FXCollections.observableArrayList();

    public PlayerModel(String playerName, Color color, int balance, ImageTextItem badgeImage) {

        this.balance = balance;
        this.playerName = playerName;
        this.badgeImage = badgeImage.image();
        badgeName = badgeImage.text();
        pion = new Pion(this.badgeImage); // TODO create pionfactory?
    }

    public void addTile(TileModel tileModel) {
        ownedTiles.add(tileModel);
        fireInvalidationEvent();
    }

    public ObservableList<TileModel> getOwnedTiles() {
        return ownedTiles;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        fireInvalidationEvent();
    }

    public void changeBalance(int balance) {
        this.balance += balance;
        fireInvalidationEvent();
    }

    public int balanceProperty() {
        return balance;
    }

    public Image getBadgeImage() {
        return badgeImage;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public Pion getPion() {
        return pion;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
        fireInvalidationEvent();
    }

    public int getLeaveJailCards() {
        return leaveJailCards;
    }

    public void changeGetOutOfJailCards(int increment) {
        leaveJailCards += increment;
        fireInvalidationEvent();
    }
}