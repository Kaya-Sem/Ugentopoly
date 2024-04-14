package be.ugent.objprog.ugentopoly;

import java.util.Objects;

import be.ugent.objprog.ugentopoly.gameBoard.Board;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.players.PlayerCreatorStage;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    private static final String ICON = "chest.png";
    private static final int WINDOW_SIZE = 900;
    public static final double BOARD_SIZE = 845.0;
    public static final int SMALL_TILES = 13;

    @Override
    public void start(Stage stage) {

        XMLParser parser = new XMLParser();

        PlayerCreatorStage players = new PlayerCreatorStage();
        players.showAndWait();

        StackPane root = new StackPane();

        Label currentPlayersMove = new Label("jeffrey");

        root.getChildren().addAll(new Board(), currentPlayersMove);
        StackPane.setAlignment(currentPlayersMove, Pos.TOP_CENTER);




        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE);
        scene.getStylesheets().add(Objects
                .requireNonNull(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css")).toExternalForm());
        stage.setScene(scene);

        @SuppressWarnings("ConstantConditions")
        Image icon = new Image(getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + ICON));
        stage.getIcons().add(icon);
        stage.setFullScreen(true);
        stage.setMinWidth(WINDOW_SIZE); // Set minimum width of the window
        stage.setMinHeight(WINDOW_SIZE); // Set minimum height of the window
        stage.show();

        stage.setTitle("Ugentopoly");

        // NON-URGENT fix implement these!
        //final Dice dice = new Dice();
        //stage.setOnCloseRequest(e -> dice.close());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}