package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.charting.ChartStage;
import be.ugent.objprog.ugentopoly.factories.GameCardFactory;
import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.gameboard.Board;
import be.ugent.objprog.ugentopoly.gameboard.BoardModel;
import be.ugent.objprog.ugentopoly.gamecards.CardDeck;
import be.ugent.objprog.ugentopoly.gamecards.GameCardInitializer;
import be.ugent.objprog.ugentopoly.logs.LogListView;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.playertabpane.PlayerTabPane;
import be.ugent.objprog.ugentopoly.tiles.InitializedTilesObject;
import be.ugent.objprog.ugentopoly.tiles.TileInitializer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UgentopolyScene extends Scene {

    public static final double BOARD_SIZE = 845.0;

    public UgentopolyScene(List<PlayerModel> playerModelList, XMLParser parser, Stage stage) {
        super(new StackPane(), BOARD_SIZE, BOARD_SIZE);
        getStylesheets().add(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css").toExternalForm());

        BoardModel boardModel = new BoardModel();
        DisplayCardController cardController = new DisplayCardController(boardModel);

        TileFactory tileFactory = new TileFactory(parser.areaColors(), parser.getStartAmount(), cardController);

        TileInitializer tileInitializer = new TileInitializer(parser, tileFactory);
        InitializedTilesObject tilesObject = tileInitializer.TileModelInitializer();

        GameCardInitializer gameCardInitializer = new GameCardInitializer(parser, new GameCardFactory());

        CardDeck chanceCardDeck = gameCardInitializer.getChanceCards();
        CardDeck chestCardDeck = gameCardInitializer.getChestCards();

        GameModel gameModel = new GameModel(playerModelList, tilesObject.tileModelArray(), chanceCardDeck, chestCardDeck);

        GameController gameController = new GameController(stage, gameModel);
        gameModel.setGameController(gameController);

        PlayerTabPane playerTabPane = new PlayerTabPane(gameModel.getPlayerModels());

        // Charting
        Button chartButton = new Button("Toon balansgrafiek");
        chartButton.setOnAction(event -> {
            ChartStage chartStage = new ChartStage(stage, playerModelList);
            chartStage.show();
        });

        VBox verticalComponents = new VBox();
        verticalComponents.setSpacing(10);
        verticalComponents.setAlignment(Pos.CENTER);

        verticalComponents.getChildren().addAll(
                new CurrentPlayerIndicator(gameModel),
                chartButton,
                playerTabPane,
                new LogListView(gameModel.getLogs()),
                gameController.getDiceRoller());

        HBox horizontalLayout = new HBox();
        horizontalLayout.setSpacing(20);
        horizontalLayout.setAlignment(Pos.CENTER);

        horizontalLayout.getChildren().addAll(
                new Board(boardModel,
                        tilesObject),
                verticalComponents);

        StackPane root = (StackPane) getRoot();
        root.getChildren().add(horizontalLayout);
    }
}