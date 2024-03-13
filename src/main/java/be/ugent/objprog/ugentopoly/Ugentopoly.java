package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.dice.Dice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ugentopoly extends Application {
    @Override
    public void start(Stage stage) {
        final Dice dice = new Dice();

        Button btn = new Button();
        btn.setText("Rol dobbelstenen");
        btn.setOnAction(event -> dice.roll(t -> System.out.println("Klaar met rollen")));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Dobbelstenen");
        stage.setOnCloseRequest(e -> dice.close());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}