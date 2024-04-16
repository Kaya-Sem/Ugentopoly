package be.ugent.objprog.ugentopoly;

import java.util.ArrayList;
import java.util.List;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameModel implements Observable {

    private final List<InvalidationListener> listenerList = new ArrayList<>();
    private final List<PlayerModel> playerModels;
    private PlayerModel currentPlayerMove = null;


    public GameModel(List<PlayerModel> players) {
        playerModels = players;
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
        return playerModels;
    }

    public PlayerModel getCurrentPlayerMove() {
        return currentPlayerMove;
    }

    public void setCurrentPlayerMove(PlayerModel currentPlayerMove) {
        this.currentPlayerMove = currentPlayerMove;
    }
}