package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.ArrayDeque;
import java.util.List;

public class PlayerQueue extends ArrayDeque<PlayerModel> {
    public PlayerQueue(List<PlayerModel> playerModels) {
        addAll(playerModels);
    }

    public PlayerModel getNextPlayer() {
        rotate();
        return getFirst();
    }

    private void rotate() {
        addLast(pollFirst());
    }
}