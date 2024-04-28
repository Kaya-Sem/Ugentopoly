package be.ugent.objprog.ugentopoly;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class Ugentopoly extends Application {
    private static final String APPLICATIONNAME = "Ugentopoly";
    private static final double WINDOW_WIDTH = 1700.0;
    private static final double WINDOW_HEIGHT = 1200.0;
    public final XMLParser parser = new XMLParser(); // TODO move to auxillary class

    // HACK decouple
    @Override
    public void start(Stage primaryStage) {

        PlayerCreatorStage playerCreatorStage = new PlayerCreatorStage(parser.getStartingBalance());
        List<PlayerModel> players = playerCreatorStage.showAndWaitForPlayers();

        // HACK create Auxillary object class

        BoardModel boardModel = new BoardModel();
        DisplayCardController cardController = new DisplayCardController(boardModel);

        TileFactory factory = new TileFactory(parser.areaColors(), parser.getStartAmount(), cardController);
        TileInitializer tileInitializer = new TileInitializer(parser, factory);
        Map<String, Object[]> tileMap = tileInitializer.TileModelInitializer();
        Object[] tileModelMap =  tileMap.get("models");

        GameCardInitializer gameCardInitializer = new GameCardInitializer(parser, new GameCardFactory());

        DiceModel diceModel = new DiceModel();

        GameModel gameModel = new GameModel(
                players,
                tileModelMap,
                gameCardInitializer.getChanceCards(),
                gameCardInitializer.getChestCards(),
                diceModel
        );

        GameController gameController = new GameController(primaryStage, gameModel, diceModel);
        DiceRoller diceRoller = new DiceRoller(diceModel);

        // todo create method for initializeing UI elements
        CurrentPlayerIndicator playerIndicator = new CurrentPlayerIndicator(gameModel);

        PlayerTabPane playerTabPane = new PlayerTabPane(gameModel.getPlayerModels());

        HBox horizontalLayout = new HBox();
        horizontalLayout.setAlignment(Pos.CENTER);
        horizontalLayout.setSpacing(60);

        ListView logListView = new ListView();
        logListView.setMaxHeight(845);
        logListView.setMaxWidth(600);
        logListView.setItems(gameModel.getLogs());
        logListView.setSelectionModel(null);
        // TODO add custom cell factory to include badge

        horizontalLayout.getChildren().addAll(logListView, new Board(boardModel,tileMap), playerTabPane);

        StackPane root = new StackPane(horizontalLayout, playerIndicator, diceRoller);

        StackPane.setAlignment(playerIndicator, Pos.TOP_CENTER);
        StackPane.setAlignment(playerTabPane, Pos.CENTER_RIGHT);
        StackPane.setAlignment(diceRoller, Pos.BOTTOM_RIGHT);

        applySettings(primaryStage);

        Scene scene = new Scene(root, BoardModel.BOARD_SIZE, BoardModel.BOARD_SIZE);

        scene.getStylesheets().add(Objects
                .requireNonNull(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css")).toExternalForm());

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