package be.ugent.objprog.ugentopoly.players;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

// TODO put a limit on name length
// TODO mark in red when somehting is not filled in

public class PlayerCustomizer extends VBox {
    protected static final double PADDING = 20.0;

    private final ComboBox<ImageTextItem> badgeComboBox = new ComboBox<>();

    private final String playerNumber;
    private final TextField field = new TextField();
    private final ColorPicker colorPicker = new ColorPicker();
    private final PlayerCreatorStage creator;
    private final List<Node> children = List.of(field, badgeComboBox, colorPicker);

    PlayerCustomizer(PlayerCreatorStage creator, String textFieldHint, String playerNumber) {
        this.creator = creator;
        this.playerNumber = playerNumber;

        field.setPromptText(textFieldHint);
        field.setAlignment(Pos.CENTER);

        badgeComboBox.setPromptText("Select badge");
        colorPicker.setPromptText("Select color");

        // Disable the selected badge for other players
        badgeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            creator.playerCustomizers.stream().filter(customizer -> !customizer.equals(this)).forEach(customizer -> {
                if (null != oldValue && !customizer.badgeComboBox.getItems().contains(oldValue)) {
                    customizer.badgeComboBox.getItems().add(oldValue);
                }
                customizer.badgeComboBox.getItems().remove(newValue);
            });
        });


        getChildren().addAll(field, badgeComboBox, colorPicker, new button());
        setSpacing(PADDING);
    }


    // HACK smelly
    private class button extends ToggleButton {
        private button() {
            setAlignment(Pos.CENTER);
            setText("READY");

            setOnAction(event -> {
                if (isSelected()) {

                        creator.players.put(playerNumber, new PlayerModel(
                                field.getText(),
                                colorPicker.getValue(),
                                Integer.parseInt(creator.balance),
                                getBadgeComboBox().getValue()

                        ));
                        children.forEach(child -> child.setDisable(true));

                        // remove
                        System.out.println("Current map: " + creator.players);
                } else {
                    creator.players.remove(playerNumber);
                    children.forEach(child -> child.setDisable(false));
                    System.out.println("Current map: " + creator.players); // remove
                }
            });
        }
    }

    ComboBox<ImageTextItem> getBadgeComboBox() {
        return badgeComboBox;
    }
}