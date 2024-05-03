package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TilePurchaseAlert extends Alert {

    protected static final int SPACING = 20;
    @SuppressWarnings("FieldCanBeLocal")
    private final ButtonType buttonNo = new ButtonType("No");
    private final ButtonType buttonYes = new ButtonType("BUY");

    public TilePurchaseAlert(String header, String cost, TemplateCard card) {
        super(AlertType.CONFIRMATION);
        setTitle(header);
        setGraphic(null);
        setHeaderText(null);

        VBox contentLayout = new VBox(SPACING);
        contentLayout.setPadding(new Insets(SPACING, 10, 10, 10));

        Label contentLabel = new Label("Wilt u " + header + " kopen voor €" + cost + "?"  );

        contentLabel.getStyleClass().add("bold-label-large");

        contentLayout.getChildren().addAll(card, contentLabel);

        getDialogPane().setContent(contentLayout);

        getButtonTypes().setAll(buttonNo, buttonYes);
    }

    // Show the alert and await user response, returning true if they choose "BUY"
    public boolean wasBought() {
        return showAndWait().filter(response -> response == buttonYes).isPresent();
    }
}