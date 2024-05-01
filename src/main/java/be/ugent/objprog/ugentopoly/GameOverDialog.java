package be.ugent.objprog.ugentopoly;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class GameOverDialog {
    private final String message;
    private final List<PlayerModel> players;
    private final List<PlayerModel> winningPlayers;

    public GameOverDialog(PlayerModel loser, List<PlayerModel> allPlayers) {
        winningPlayers = new ArrayList<>(allPlayers.stream()
                .filter(player -> !player.equals(loser))  // Exclude the losing player
                .toList());

        players = allPlayers;

        // Construct the ranking message
        StringBuilder rankingMessage = new StringBuilder(loser.getName()).append(" verloor!\n\nRankings:\n");
        winningPlayers.sort((p1, p2) -> Integer.compare(p2.getBalance(), p1.getBalance()));
        for (int i = 0; i < winningPlayers.size(); i++) {
            rankingMessage.append(i + 1).append(". ")
                    .append(winningPlayers.get(i).getName()).append(" €")
                    .append(winningPlayers.get(i).getBalance()).append("\n");
        }
        message = rankingMessage.toString();
        show();
        displayChart();
    }

    public void show() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Game Over!");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void displayChart() {
        Platform.runLater(() -> {
            Stage chartStage = new Stage();
            chartStage.setTitle("Balance Chart");

            NumberAxis xAxis = new NumberAxis();
            xAxis.setLabel("Move Number");
            xAxis.setAutoRanging(false);

            // Calculate the range and tick unit dynamically based on the number of moves
            int maxMoves = players.stream()
                    .mapToInt(player -> player.getBalanceHistory().size())
                    .max()
                    .orElse(1) - 1;
            xAxis.setLowerBound(0);
            xAxis.setUpperBound(maxMoves);
            xAxis.setTickUnit(1); // Set tick unit as 1 to display integers
            xAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(xAxis) {
                @Override
                public String toString(Number object) {
                    return String.format("%d", object.intValue());
                }
            });

            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Balance");

            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle("Player Balances Over Time");

            for (PlayerModel player : players) {
                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName(player.getName());
                List<Integer> balances = player.getBalanceHistory();
                for (int i = 0; i < balances.size(); i++) {
                    series.getData().add(new XYChart.Data<>(i, balances.get(i)));
                }
                lineChart.getData().add(series);
            }

            Scene scene = new Scene(lineChart, 800, 600);
            chartStage.setScene(scene);
            chartStage.show();
        });
    }
}