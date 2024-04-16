package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class GameModel implements Observable {

    private final List<InvalidationListener> listenerList = new ArrayList<>();
    private final List<PlayerModel> playerModels;
    private PlayerModel currentPlayerMove;

    public GameModel(List<PlayerModel> players) {
        playerModels = new ArrayList<>(players);
        currentPlayerMove = playerModels.getFirst(); // assign first player to move

        // NEEDSLOG
    }

    private void fireInvalidationEvent() {
        listenerList.forEach(listener -> listener.invalidated(this));
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listenerList.add(listener);
    }

    public List<PlayerModel> getPlayerModels() {
        return Collections.unmodifiableList(playerModels);
    }

    public PlayerModel getCurrentPlayerMove() {
        return currentPlayerMove;
    }

    public void setCurrentPlayerMove(PlayerModel currentPlayerMove) {
        this.currentPlayerMove = currentPlayerMove;
        fireInvalidationEvent();
    }
}
