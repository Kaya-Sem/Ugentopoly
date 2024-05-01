package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.scene.control.Alert;

import java.util.Comparator;
import java.util.List;

public class GameOverDialog {
    private final String message;

    public GameOverDialog(PlayerModel loser, List<PlayerModel> allPlayers) {
        // Filter out the losing player and sort remaining players by balance in descending order
        List<PlayerModel> sortedPlayers = allPlayers.stream()
                .filter(player -> !player.equals(loser))
                .sorted(Comparator.comparing(PlayerModel::getBalance, Comparator.reverseOrder()))
                .toList();

        StringBuilder rankingMessage = new StringBuilder(loser.getName() + " ").append("verloor!\n\n").append("Rankings:\n");

        int rank = 1;
        for (PlayerModel player : sortedPlayers) {
            rankingMessage.append(rank).append(". ")
                    .append(player.getName()).append("  €")
                    .append(player.getBalance()).append("\n");
            rank++;
        }

        message = rankingMessage.toString();
    }

    public void show() {
        // Create and display the alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over!");
        alert.setContentText(message.toString());
        alert.showAndWait();
    }
}