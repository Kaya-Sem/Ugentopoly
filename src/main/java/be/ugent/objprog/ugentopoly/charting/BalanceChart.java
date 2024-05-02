package be.ugent.objprog.ugentopoly.charting;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import be.ugent.objprog.ugentopoly.players.PlayerModel;

import java.util.List;

public class BalanceChart extends LineChart<Number, Number> {

    public BalanceChart(List<PlayerModel> players) {
        super(new NumberAxis(), new NumberAxis());
        initializeAxes(players);
        populateData(players);
    }

    private void initializeAxes(List<PlayerModel> players) {
        NumberAxis xAxis = (NumberAxis) getXAxis();
        xAxis.setLabel("Aantal moves");
        xAxis.setAutoRanging(false);

        int maxMoves = players.getFirst().getBalanceHistory().size() + 1; // dont squash against border

        xAxis.setLowerBound(0);
        xAxis.setUpperBound(maxMoves);
        xAxis.setTickUnit(1);
        xAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(xAxis) {
            @Override
            public String toString(Number object) {
                return String.format("%d", object.intValue());
            }
        });

        NumberAxis yAxis = (NumberAxis) getYAxis();
        yAxis.setLabel("Balans");
    }

    private void populateData(List<PlayerModel> players) {
        for (PlayerModel player : players) {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(player.getName());
            List<Integer> balances = player.getBalanceHistory();
            for (int i = 0; i < balances.size(); i++) {
                series.getData().add(new XYChart.Data<>(i, balances.get(i)));
            }
            getData().add(series);
        }
    }
}