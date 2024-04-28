package be.ugent.objprog.ugentopoly;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class TilePurchaseAlert extends Alert {

    private final ButtonType buttonYes = new ButtonType("BUY");
    private final ButtonType buttonNo = new ButtonType("No");

    public TilePurchaseAlert(String header, String cost) {
        super(AlertType.CONFIRMATION);
        setTitle("Koop Tile");
        setHeaderText(header);
        setContentText(header + " kopen voor €" + cost + "?"  );
        getButtonTypes().setAll(buttonNo, buttonYes);
    }

    public boolean showAndAwaitResponse() {
        return showAndWait().filter(response -> response == buttonYes).isPresent();
    }
}