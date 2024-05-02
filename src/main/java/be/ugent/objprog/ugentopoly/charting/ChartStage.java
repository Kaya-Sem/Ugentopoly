package be.ugent.objprog.ugentopoly.charting;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class ChartStage extends Stage {
    protected static final int CHARTSTAGEHEIGHT = 600;
    protected static final int CHARTSTAGEWIDTH = 400;

    public ChartStage(Stage stage, List<PlayerModel> playerModelList) {
        initModality(Modality.WINDOW_MODAL);
        initOwner(stage);

        BalanceChart balanceChart = new BalanceChart(playerModelList);
        Scene chartScene = new Scene(balanceChart, CHARTSTAGEHEIGHT, CHARTSTAGEWIDTH);
        setScene(chartScene);
        setTitle("Speler balansgrafiek");
    }
}