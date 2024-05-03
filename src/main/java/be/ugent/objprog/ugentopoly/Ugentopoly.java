package be.ugent.objprog.ugentopoly;

import java.util.List;

import be.ugent.objprog.ugentopoly.charting.ChartStage;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.players.PlayerCreatorStage;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    private static final String APPLICATIONNAME = "Ugentopoly";
    private static final double WINDOW_WIDTH = 1700.0; // TODO test on 1080p
    private static final double WINDOW_HEIGHT = 1200.0;

    @Override
    public void start(Stage primaryStage) {

        XMLParser parser = new XMLParser();
        PlayerCreatorStage playerCreatorStage = new PlayerCreatorStage(primaryStage, parser.getStartingBalance());
        List<PlayerModel> players = playerCreatorStage.showAndWaitForPlayers();

        if (playerCreatorStage.isCancelled()) {
            primaryStage.close();
            return;
        }

        // apply gameover condition
        players.forEach(playerModel -> playerModel.balanceProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if (newValue.intValue() <= 0) {
                        players.forEach(PlayerModel::updateBalanceHistory);

                        primaryStage.close();

                        GameOverDialog dialog = new GameOverDialog(playerModel, players);
                        dialog.show();

                        Stage chartStage = new ChartStage(new Stage(), players);
                        chartStage.show();
                    }
                }
        ));

        Scene ugentopolyScene = new UgentopolyScene(players, parser, primaryStage);

        primaryStage.getIcons().add(new CustomImage("chest.png"));
        primaryStage.setFullScreen(true);
        primaryStage.setMinWidth(WINDOW_WIDTH);
        primaryStage.setMinHeight(WINDOW_HEIGHT);
        primaryStage.setTitle(APPLICATIONNAME);

        primaryStage.setScene(ugentopolyScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}