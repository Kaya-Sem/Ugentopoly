package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.dice.Dice;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    static final String ICON = "tax.png";
    @Override
    public void start(Stage stage) {

        final Dice dice = new Dice();
        //Color backgroundColor = Color.rgb(0,  255, 202);

        StackPane root = new StackPane(new Board());




        Scene scene = new Scene(root, 900, 900 );
        stage.setScene(scene);



        @SuppressWarnings("ConstantConditions")
        Image icon = new Image(getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + ICON));
        stage.getIcons().add(icon);
        stage.setFullScreen(false);
        stage.setMinWidth(845); // Set minimum width of the window
        stage.setMinHeight(845); // Set minimum height of the window
        stage.show();

        stage.setTitle("Ugentopoly");
        stage.setOnCloseRequest(e -> dice.close());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}