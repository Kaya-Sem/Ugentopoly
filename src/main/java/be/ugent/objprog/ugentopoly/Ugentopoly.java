package be.ugent.objprog.ugentopoly;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import be.ugent.objprog.ugentopoly.dice.DiceModel;
import be.ugent.objprog.ugentopoly.dice.DiceRoller;
import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.gameBoard.Board;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.players.PlayerCreatorStage;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.players.PlayerTabPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    private static final String APPLICATIONNAME = "Ugentopoly";
    private static final double WINDOW_WIDTH = 1700.0;
    private static final double WINDOW_HEIGHT = 1200.0;
    public static final double BOARD_SIZE = 845.0;
    public final XMLParser parser = new XMLParser();

    @Override
    public void start(Stage primaryStage) {

        PlayerCreatorStage playerCreatorStage = new PlayerCreatorStage(parser.getStartingBalance());
        List<PlayerModel> players = playerCreatorStage.showAndWaitForPlayers();

        TileFactory factory = new TileFactory(parser.areaColors());
        TileInitializer tileInitializer = new TileInitializer(parser, factory);
        Map<String, Object[]> tileMap = tileInitializer.TileModelInitializer();

        GameModel gameModel = new GameModel(players, tileMap);

        GameController gameController = new GameController(primaryStage, gameModel, new DiceModel());
        DiceRoller diceRoller = new DiceRoller(gameController.getDiceModel());

        // todo create method for initializeing UI elements
        CurrentPlayerIndicator playerIndicator = new CurrentPlayerIndicator(gameModel);

        PlayerTabPane playerTabPane = new PlayerTabPane(gameModel.getPlayerModels());


        StackPane root = new StackPane(new Board(tileMap), playerIndicator, playerTabPane, diceRoller);

        StackPane.setAlignment(playerIndicator, Pos.TOP_CENTER);
        StackPane.setAlignment(playerTabPane, Pos.CENTER_RIGHT);
        StackPane.setAlignment(diceRoller, Pos.BOTTOM_RIGHT);

        applySettings(primaryStage);

        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE);

        scene.getStylesheets().add(Objects
                .requireNonNull(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css")).toExternalForm());
        primaryStage.setScene(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void applySettings(Stage primaryStage) {
        primaryStage.getIcons().add(ApplicationIcon.icon());
        primaryStage.setFullScreen(true);
        primaryStage.setMinWidth(WINDOW_WIDTH); // Set minimum width of the window
        primaryStage.setMinHeight(WINDOW_HEIGHT); // Set minimum height of the window
        primaryStage.setTitle(APPLICATIONNAME);
    }

    public static void main(String[] args) {
        launch();
    }
}