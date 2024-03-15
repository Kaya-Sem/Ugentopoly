package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.dice.Dice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    static final String LOGO = "/be/ugent/objprog/ugentopoly/assets/tax.png";
    @Override
    public void start(Stage stage) {



        final Dice dice = new Dice();
        //Color backgroundColor = Color.rgb(0,  255, 202);

        StackPane root = new StackPane();






        Scene scene = new Scene(root, 845, 845);
        //scene.setFill(backgroundColor);

        Image icon = new Image(getClass().getResourceAsStream(LOGO));
        stage.getIcons().add(icon);
        stage.setFullScreen(false);


        stage.setTitle("Ugentopoly");
        stage.setOnCloseRequest(e -> dice.close());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}