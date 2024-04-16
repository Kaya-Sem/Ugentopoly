package be.ugent.objprog.ugentopoly;

import java.util.List;
import java.util.Objects;

import be.ugent.objprog.ugentopoly.gameBoard.Board;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.playerTabPane.PlayerTabPane;
import be.ugent.objprog.ugentopoly.players.PlayerCreatorStage;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    private static final String ICON = "chest.png";
    private static final double WINDOW_SIZE = 900.0;
    public static final double BOARD_SIZE = 845.0;
    public static final int SMALL_TILES = 13;

    @Override
    public void start(Stage primaryStage) {


        XMLParser parser = new XMLParser();

        PlayerCreatorStage playerCreatorStage = new PlayerCreatorStage(parser.getStartingBalance());
        List<PlayerModel> players = playerCreatorStage.showAndWaitForPlayers();

        GameModel gameModel = new GameModel(players);

        StackPane root = new StackPane();

        CurrentPlayerIndicator playerIndicator = new CurrentPlayerIndicator(gameModel);


        // create tabs for players
        PlayerTabPane playerTabPane = new PlayerTabPane(gameModel.getPlayerModels());



        root.getChildren().addAll(new Board(), playerIndicator, playerTabPane);
        StackPane.setAlignment(playerIndicator, Pos.TOP_CENTER);
        StackPane.setAlignment(playerTabPane, Pos.CENTER_RIGHT);




        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE);
        scene.getStylesheets().add(Objects
                .requireNonNull(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css")).toExternalForm());
        primaryStage.setScene(scene);

        @SuppressWarnings("ConstantConditions")
        Image icon = new Image(getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + ICON));
        primaryStage.getIcons().add(icon);
        primaryStage.setFullScreen(true);
        primaryStage.setMinWidth(WINDOW_SIZE); // Set minimum width of the window
        primaryStage.setMinHeight(WINDOW_SIZE); // Set minimum height of the window
        primaryStage.show();

        primaryStage.setTitle("Ugentopoly");

        // NON-URGENT fix implement these!
        //final Dice dice = new Dice();
        //stage.setOnCloseRequest(e -> dice.close());

        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}