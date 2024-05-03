package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class GameOverDialog {
    private final String message;

    public GameOverDialog(PlayerModel loser, List<PlayerModel> allPlayers) {
        List<PlayerModel> winningPlayers = new ArrayList<>(allPlayers.stream()
                .filter(player -> !player.equals(loser))
                .toList());

        StringBuilder rankingMessage = new StringBuilder(loser.getName()).append(" verloor!\n\nRanking:\n");
        winningPlayers.sort((p1, p2) -> Integer.compare(p2.getBalance(), p1.getBalance()));
        for (int i = 0; i < winningPlayers.size(); i++) {
            rankingMessage.append(i + 1).append(". ")
                    .append(winningPlayers.get(i).getName()).append(" €")
                    .append(winningPlayers.get(i).getBalance()).append("\n");
        }
        message = rankingMessage.toString();
    }

    public void show() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over!");
        alert.setContentText(message);
        alert.showAndWait();
    }
}