package be.ugent.objprog.ugentopoly;

import java.util.*;

import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.logging.LogElement;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.players.PlayerQueue;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameModel extends CustomObservable {

    private final ObservableList<LogElement> logs = FXCollections.observableArrayList();
    private GameController gameController = null;
    private PlayerModel currentPlayer = null;
    private final List<PlayerModel> playerModels;
    private final PlayerQueue playerModelQueue;
    private final TileModel[] tileModels;
    private int bonusPot = 0;
    private int lastRoll = 1; // neutral element for multiplication utility

    private final CardDeck chanceCardDeck;
    private final CardDeck chestCardDeck;

    public GameModel(List<PlayerModel> players,
                     TileModel[] tileModels,
                     CardDeck chanceCardDeck,
                     CardDeck chestCardDeck
                     ) {
        this.tileModels = tileModels;
        playerModels = new ArrayList<>(players);
        playerModelQueue = new PlayerQueue(playerModels);
        this.chanceCardDeck = chanceCardDeck;
        this.chestCardDeck = chestCardDeck;
    }

    public PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerModel currentPlayer) {
        this.currentPlayer = currentPlayer;
        fireInvalidationEvent();
    }

    public TileModel[] getTileModels() {
        return tileModels;
    }

    public PlayerQueue getPlayerModelQueue() {
        return playerModelQueue;
    }

    public List<PlayerModel> getPlayerModels() {
        return playerModels;
    }

    public CardDeck getChestCardDeck() {
        return chestCardDeck;
    }

    public CardDeck getChanceCardDeck() {
        return chanceCardDeck;
    }

    public int getBonusPot() {
        return bonusPot;
    }

    public void setBonusPot(int bonusPot) {
        this.bonusPot = bonusPot;
        fireInvalidationEvent();
    }

    public void changeBonusPot(int amount) {
        bonusPot += amount;
        fireInvalidationEvent();
    }

    public void addLog(String player, String action) {
        logs.add(new LogElement(player, action));
        fireInvalidationEvent();
    }

    public void addLog(String message) {
        logs.add(new LogElement(message));
        fireInvalidationEvent();
    }

    public ObservableList<LogElement> getLogs() {
        return logs;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        fireInvalidationEvent();
    }

    public int getLastRoll() {
        return lastRoll;
    }

    public void setLastRoll(int lastRoll) {
        this.lastRoll = lastRoll;
    }
}