package be.ugent.objprog.ugentopoly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceChart extends Application {

    @Override
    public void start(Stage stage) {
        // Create Axes
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Time");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Balance");

        // Create LineChart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Player Balances Over Time");

        // Example Data
        Map<PlayerModel, List<Integer>> playerBalances = getPlayerBalances();

        // Adding data to chart
        for (Map.Entry<PlayerModel, List<Integer>> entry : playerBalances.entrySet()) {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(entry.getKey().getName()); // Assuming PlayerModel has a getName method
            List<Integer> balances = entry.getValue();
            for (int i = 0; i < balances.size(); i++) {
                series.getData().add(new XYChart.Data<>(i, balances.get(i)));
            }
            lineChart.getData().add(series);
        }

        // Setup Scene
        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    private Map<PlayerModel, List<Integer>> getPlayerBalances() {
        // Mock function to represent fetching of data
        Map<PlayerModel, List<Integer>> balances = new HashMap<>();
        PlayerModel alice = new PlayerModel("Alice");
        PlayerModel bob = new PlayerModel("Bob");

        balances.put(alice, List.of(500, 600, 700, 800));
        balances.put(bob, List.of(400, 300, 200, 100));

        return balances;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class PlayerModel {
    private String name;

    public PlayerModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}