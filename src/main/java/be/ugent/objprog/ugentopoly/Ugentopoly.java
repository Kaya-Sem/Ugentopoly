package be.ugent.objprog.ugentopoly;

import java.util.List;
import java.util.Objects;

import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.dice.DiceModel;
import be.ugent.objprog.ugentopoly.dice.DiceRoller;
import be.ugent.objprog.ugentopoly.factories.GameCardFactory;
import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.gameBoard.Board;
import be.ugent.objprog.ugentopoly.gameBoard.BoardModel;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.players.PlayerCreatorStage;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.playertabpane.PlayerTabPane;
import be.ugent.objprog.ugentopoly.tiles.InitializedTilesObject;
import be.ugent.objprog.ugentopoly.tiles.TileInitializer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class Ugentopoly extends Application {
    private static final String APPLICATIONNAME = "Ugentopoly";
    private static final double WINDOW_WIDTH = 1700.0;
    private static final double WINDOW_HEIGHT = 1200.0;
    public final XMLParser parser = new XMLParser();

    @Override
    public void start(Stage primaryStage) {

        PlayerCreatorStage playerCreatorStage = new PlayerCreatorStage(parser.getStartingBalance());
        List<PlayerModel> players = playerCreatorStage.showAndWaitForPlayers();

        ComponentInitializer components = new ComponentInitializer(parser, players);
        GameModel gameModel = components.getGameModel();

        GameController gameController = new GameController(primaryStage, components.getGameModel(), components.getDiceModel());
        gameModel.setGameController(gameController);

        DiceRoller diceRoller = new DiceRoller(components.getDiceModel());

        VBox verticalComponents = new VBox();
         verticalComponents.setSpacing(10);
         verticalComponents.setAlignment(Pos.CENTER);
        PlayerTabPane playerTabPane = new PlayerTabPane(gameModel.getPlayerModels());

        ListView logListView = new ListView();
        logListView.setItems(gameModel.getLogs());
        logListView.setSelectionModel(null);

         verticalComponents.getChildren().addAll(new CurrentPlayerIndicator(gameModel), playerTabPane, logListView, diceRoller);

        HBox horizontalLayout = new HBox();
        horizontalLayout.setAlignment(Pos.CENTER);

        horizontalLayout.getChildren().addAll(
                new Board(components.getBoardModel(),
                          components.getInitializedTilesObject()),
                          verticalComponents);

        StackPane root = new StackPane(horizontalLayout);

        StackPane.setAlignment(playerTabPane, Pos.CENTER_RIGHT);
        StackPane.setAlignment(diceRoller, Pos.BOTTOM_RIGHT);

        applySettings(primaryStage);

        Scene scene = new Scene(root, BoardModel.BOARD_SIZE, BoardModel.BOARD_SIZE);

        scene.getStylesheets().add(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css").toExternalForm());

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