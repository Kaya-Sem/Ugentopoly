package be.ugent.objprog.ugentopoly.players;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

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
            for (PlayerCustomizer customizer : creator.playerCustomizers) {
                if (!customizer.equals(this)) {
                    if (null != oldValue && !customizer.badgeComboBox.getItems().contains(oldValue)) {
                        customizer.badgeComboBox.getItems().add(oldValue);
                    }
                    customizer.badgeComboBox.getItems().remove(newValue);
                }
            }
        });


        getChildren().addAll(field, badgeComboBox, colorPicker, new button());
        setSpacing(PADDING);
    }

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

                    System.out.println("Current map: " + creator.players);
                } else {
                    creator.players.remove(playerNumber);
                    children.forEach(child -> child.setDisable(false));
                    System.out.println("Current map: " + creator.players);
                }
            });
        }
    }

    ComboBox<ImageTextItem> getBadgeComboBox() {
        return badgeComboBox;
    }
}