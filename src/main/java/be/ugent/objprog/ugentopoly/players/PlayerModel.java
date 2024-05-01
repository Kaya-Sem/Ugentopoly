package be.ugent.objprog.ugentopoly.players;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.factories.PionFactory;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel extends CustomObservable {

    private final ObservableList<TileModel> ownedTiles = FXCollections.observableArrayList();
    private final SimpleIntegerProperty balance = new SimpleIntegerProperty();
    private final Image badgeImage;
    private final String badgeName;
    private boolean inJail = false;
    private int leaveJailCards = 0;
    private final String name;
    private int position = 0;
    private final Pion pion;

    // history for balance line chart TODO make observable for real time charting?
    private final List<Integer> balanceHistory = new ArrayList<>();

    public PlayerModel(String name, int initialBalance, ImageTextItem badgeImage) {
        this.balance.set(initialBalance);
        this.name = name;
        this.badgeImage = badgeImage.image();
        badgeName = badgeImage.text();
        pion = PionFactory.createPion(this.badgeImage);
        balanceHistory.add(initialBalance);
    }

    public List<Integer> getBalanceHistory() {
        return balanceHistory;
    }

    public void updateBalanceHistory() {
        balanceHistory.add((balance.getValue() < 0) ? 0 : balance.getValue());
    }

    public void addBuyable(TileModel tileModel) {
        ownedTiles.add(tileModel);
        fireInvalidationEvent();
    }

    public ObservableList<TileModel> getOwnedTiles() {
        return ownedTiles;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance.getValue();
    }

    public void setBalance(int balance) {
        this.balance.set(balance);
        fireInvalidationEvent();
    }

    public void changeBalance(int balance) {
        this.balance.set(this.balance.getValue() + balance);
        fireInvalidationEvent();
    }

    public SimpleIntegerProperty balanceProperty() {
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        fireInvalidationEvent();
    }
}