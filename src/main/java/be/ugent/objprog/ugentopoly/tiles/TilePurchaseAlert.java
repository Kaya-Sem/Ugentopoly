package be.ugent.objprog.ugentopoly.tiles;

import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TilePurchaseAlert extends Alert {

    @SuppressWarnings("FieldCanBeLocal")
    private final ButtonType buttonNo = new ButtonType("No");
    private final ButtonType buttonYes = new ButtonType("BUY");

    public TilePurchaseAlert(String header, String cost, TemplateCard card) {
        super(AlertType.CONFIRMATION);
        setTitle(header);
        setGraphic(null);
        setHeaderText(null);

        VBox contentLayout = new VBox(20);
        contentLayout.setPadding(new Insets(20, 10, 10, 10));

        Label contentLabel = new Label("Wilt u " + header + " kopen voor €" + cost + "?"  );

        contentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14.0));

        contentLayout.getChildren().addAll(card, contentLabel);

        getDialogPane().setContent(contentLayout);

        getButtonTypes().setAll(buttonNo, buttonYes);
    }

    // Show the alert and await user response, returning true if they chose "BUY"
    public boolean wasBought() {
        return showAndWait().filter(response -> response == buttonYes).isPresent();
    }
}