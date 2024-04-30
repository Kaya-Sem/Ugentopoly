package be.ugent.objprog.ugentopoly;

import java.util.*;

import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.dice.DiceModel;
import be.ugent.objprog.ugentopoly.logging.LogElement;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GameModel extends CustomObservable {

    // TODO can't playerModels be removed?
    private final List<PlayerModel> playerModels;
    private final PlayerQueue playerModelQueue;
    private PlayerModel currentPlayerMove = null;
    private final TileModel[] tileModels;
    private final List<Pion> pionnen = new ArrayList<>();

    private final CardDeck chanceCardDeck;
    private final CardDeck chestCardDeck;

    private final DiceModel diceModel;

    private GameController gameController;

    private int bonusPot = 0;
    private final ObservableList<LogElement> logs = FXCollections.observableArrayList();

    public GameModel(List<PlayerModel> players, Object[] tileModelMap, CardDeck chanceCardDeck, CardDeck chestCardDeck, DiceModel diceModel ) {
        tileModels = (TileModel[]) tileModelMap;
        playerModels = new ArrayList<>(players);
        playerModelQueue = new PlayerQueue(playerModels);
        this.chanceCardDeck = chanceCardDeck;
        this.chestCardDeck = chestCardDeck;
        this.diceModel = diceModel;
        addPionsFromPlayers();
    }

    private void addPionsFromPlayers() {
        playerModels.forEach(model -> pionnen.add(model.getPion()));
    }

    public PlayerModel getCurrentPlayerMove() {
        return currentPlayerMove;
    }

    public void setCurrentPlayerMove(PlayerModel currentPlayerMove) {
        this.currentPlayerMove = currentPlayerMove;
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

    public DiceModel getDiceModel() {
        return diceModel;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}