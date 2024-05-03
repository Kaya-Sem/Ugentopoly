package be.ugent.objprog.ugentopoly.players;

import be.ugent.objprog.ugentopoly.CustomImageView;
import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.gamecards.GameCard;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel extends CustomObservable {

    private final ObservableList<TileModel> ownedTiles = FXCollections.observableArrayList();
    private final SimpleIntegerProperty balance = new SimpleIntegerProperty();
    private final Image badgeImage;
    private final String badgeName;
    private boolean inJail = false;
    private List<GameCard> leaveJailCards = new ArrayList<>();
    private final String name;
    private int position = 0;
    private final CustomImageView pion;

    // History for the balance chart. Could be made observable for live charting.
    private final List<Integer> balanceHistory = new ArrayList<>();

    public PlayerModel(String name, int initialBalance, ImageTextItem badgeImage) {
        balance.set(initialBalance);
        this.name = name;
        this.badgeImage = badgeImage.image();
        badgeName = badgeImage.text();
        pion = new CustomImageView(40, 40, this.badgeImage).addDropShadow();
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

    public ImageView getPion() {
        return pion;
    }

    public boolean isInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
        fireInvalidationEvent();
    }

    public List<GameCard> getLeaveJailCards() {
        return leaveJailCards;
    }

    public void addGetOutOfJailCard(GameCard card) {
        leaveJailCards.add(card);
        fireInvalidationEvent();
    }

    public void setGetOutOfJailCards(List<GameCard> cards) {
        leaveJailCards = cards;
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