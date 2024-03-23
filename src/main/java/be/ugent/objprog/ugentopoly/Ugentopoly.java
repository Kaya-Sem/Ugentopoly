package be.ugent.objprog.ugentopoly;
import be.ugent.objprog.dice.Dice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Properties;

public class Ugentopoly extends Application {
    private static final String ICON = "tax.png";
    private static final int WINDOW_SIZE = 900;
    public static final double BOARD_SIZE = 845.0;
    public static final int SMALL_TILES = 13;

    @Override
    public void start(Stage stage) {

        Properties prop = new Properties();
        try {prop.load(getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Dice dice = new Dice();
        StackPane root = new StackPane(new Board());
        Scene scene = new Scene(root, BOARD_SIZE, BOARD_SIZE );
        scene.getStylesheets().add("/resources/styles.css");
        stage.setScene(scene);

        @SuppressWarnings("ConstantConditions")
        Image icon = new Image(getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + ICON));
        stage.getIcons().add(icon);
        stage.setFullScreen(Boolean.parseBoolean(prop.getProperty("fullscreen")));
        stage.setMinWidth(WINDOW_SIZE); // Set minimum width of the window
        stage.setMinHeight(WINDOW_SIZE); // Set minimum height of the window
        stage.show();

        stage.setTitle(prop.getProperty("title"));
        stage.setOnCloseRequest(e -> dice.close());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}