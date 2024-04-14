package be.ugent.objprog.ugentopoly.players;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerCreatorStage extends Stage {

    private static final ObservableList<String> badgeOptions = FXCollections.observableArrayList(
            "badge 1", "Badge 2", "badge 3", "badge 4"
    );

    private final PlayerCustomizer[] playerCustomizers;

    public PlayerCreatorStage() {
        initModality(Modality.APPLICATION_MODAL);
        setAlwaysOnTop(true);
        setTitle("Add players");

        Button startGame = new Button("Start game!");
        startGame.setOnAction(e -> this.close());

        HBox hBox = new HBox();

        this.playerCustomizers = new PlayerCustomizer[]{
                new PlayerCustomizer("Kris Koolsaet"),
                new PlayerCustomizer("Bart De Bruyn"),
                new PlayerCustomizer("Peter Dawyndt"),
                new PlayerCustomizer("Veerle Fack")
        };

        for (PlayerCustomizer customizer : playerCustomizers) {
            customizer.getBadgeComboBox().getItems().addAll(badgeOptions);
        }

        hBox.getChildren().addAll(playerCustomizers);
        hBox.setSpacing(50);
        hBox.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.setPadding(new Insets(30, 30, 30, 30));
        root.getChildren().addAll(hBox, startGame);
        root.setAlignment(startGame, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root, 1000, 400);
        this.setScene(scene);

    }

    private class PlayerCustomizer extends VBox {
        private final ComboBox<String> badgeComboBox;
        private  final ColorPicker colorPicker;

        public PlayerCustomizer(String textFieldHint) {
            TextField field = new TextField();
            field.setPromptText(textFieldHint);
            field.setAlignment(Pos.CENTER);

            badgeComboBox = new ComboBox<>();
            badgeComboBox.setPromptText("Select badge");

            // Disable the selected badge for other players
            badgeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    for (PlayerCustomizer customizer : playerCustomizers) {
                        if (!customizer.equals(this)) {
                            customizer.getBadgeComboBox().getItems().remove(newValue);
                        }
                    }
                }
            });

            colorPicker = new ColorPicker();
            colorPicker.setPromptText("Select color");

            ToggleButton toggleButton = new ToggleButton();
            toggleButton.setText("READY");

            setSpacing(20);
            getChildren().addAll(field, badgeComboBox, colorPicker, toggleButton);
        }


        public ComboBox<String> getBadgeComboBox() {
            return badgeComboBox;
        }
    }
}