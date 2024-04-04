package be.ugent.objprog.ugentopoly;
import be.ugent.objprog.ugentopoly.gameBoard.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Ugentopoly extends Application {
    private static final String ICON = "tax.png";
    private static final int WINDOW_SIZE = 900;
    public static final double BOARD_SIZE = 845.0;
    public static final int SMALL_TILES = 13;

    public static final String resourcePath = "/be/ugent/objprog/ugentopoly/assets/";

    @Override
    public void start(Stage stage) {


        //final Dice dice = new Dice();
        StackPane root = new StackPane(new Board());
        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE );
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/be/ugent/objprog/ugentopoly/styles.css")).toExternalForm());
        stage.setScene(scene);

        @SuppressWarnings("ConstantConditions")
        Image icon = new Image(getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + ICON));
        stage.getIcons().add(icon);
        stage.setFullScreen(true);
        stage.setMinWidth(WINDOW_SIZE); // Set minimum width of the window
        stage.setMinHeight(WINDOW_SIZE); // Set minimum height of the window
        stage.show();

        stage.setTitle("Ugentopoly");
        //stage.setOnCloseRequest(e -> dice.close());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}