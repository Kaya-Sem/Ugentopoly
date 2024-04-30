package be.ugent.objprog.ugentopoly.players;

import java.util.List;

import be.ugent.objprog.ugentopoly.CustomImage;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PlayerCustomizer extends VBox {
    protected static final double PADDING = 20.0;

    private final ComboBox<ImageTextItem> badgeComboBox = new ComboBox<>();

    private final String playerNumber;
    private final TextField field = new TextField();
    private final PlayerCreatorStage creator;
    private final List<Node> children = List.of(field, badgeComboBox );

    PlayerCustomizer(PlayerCreatorStage creator, String textFieldHint, String playerNumber) {
        this.creator = creator;
        this.playerNumber = playerNumber;

        field.setPromptText(textFieldHint);
        field.setAlignment(Pos.CENTER);

        badgeComboBox.setPromptText("Select badge");

        // Disable the selected badge for other players
        badgeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> creator.playerCustomizers.stream().filter(customizer -> !customizer.equals(this)).forEach(customizer -> {
            if (null != oldValue && !customizer.badgeComboBox.getItems().contains(oldValue)) {
                customizer.badgeComboBox.getItems().add(oldValue);
            }
            customizer.badgeComboBox.getItems().remove(newValue);
        }));

setupComboBoxContextMenu();
        getChildren().addAll(field, badgeComboBox, new CustomButton());
        setSpacing(PADDING);
    }

    private void setupComboBoxContextMenu() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem addItem = new MenuItem("secret Noah badge");
        addItem.setOnAction(event -> {
            badgeComboBox.getItems().add(new ImageTextItem("Noah", new CustomImage("noah.png")));
        });
        contextMenu.getItems().add(addItem);

        badgeComboBox.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (MouseButton.SECONDARY == event.getButton()) {
                contextMenu.show(badgeComboBox, event.getScreenX(), event.getScreenY());
            } else {
                contextMenu.hide();
            }
        });
    }

    private class CustomButton extends Button {
        protected static final int MAXNAMELENGTH = 12;

        private CustomButton() {
            setAlignment(Pos.CENTER);
            setText("READY");

            setOnAction(event -> {
                if (field.getText().isBlank() || MAXNAMELENGTH < field.getText().length() || null == getBadgeComboBox().getValue()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.initOwner(PlayerCustomizer.this.getScene().getWindow()); // Set owner to the PlayerCreatorStage
                    alert.setTitle("Incomplete Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill in names, select a badge and \n make sure player name is less than 12 characters.");
                    alert.showAndWait();
                } else {
                    setDisabled(true);
                    creator.players.put(playerNumber, new PlayerModel(
                            field.getText(),
                            Integer.parseInt(creator.balance),
                            getBadgeComboBox().getValue()
                    ));
                    children.forEach(child -> child.setDisable(true));
                }
            });
        }
    }


    ComboBox<ImageTextItem> getBadgeComboBox() {
        return badgeComboBox;
    }
}