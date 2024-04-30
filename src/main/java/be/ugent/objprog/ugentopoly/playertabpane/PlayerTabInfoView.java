package be.ugent.objprog.ugentopoly.playertabpane;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.beans.binding.Bindings;


public class PlayerTabInfoView extends VBox implements InvalidationListener {

    private final PlayerModel playerModel;
    private final StringProperty playerBalance = new SimpleStringProperty();

    public PlayerTabInfoView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        playerModel.addListener(this);

        playerBalance.set(String.valueOf(this.playerModel.getBalance()));

        ListView<TileModel> playerOwnedTiles = new ListView<>(playerModel.getOwnedTiles());

        getChildren().addAll(getPlayerNameLabel(), getBalanceLabel(), playerOwnedTiles);
        setPadding(new Insets(5));
    }

    private Label getPlayerNameLabel() {
        Label playerName = new Label(playerModel.getName());
        playerName.setFont(Font.font("Arial", FontWeight.BOLD, 17));
        playerName.setAlignment(Pos.CENTER);
        return playerName;
    }

private Label getBalanceLabel() {
        Label balanceLabel = new Label();
        balanceLabel.textProperty().bind(Bindings.createStringBinding(
                () -> "€" + playerBalance.get(),
                playerBalance
        ));
        return balanceLabel;
    }

    @Override
    public void invalidated(Observable observable) {
        // TODO
        playerBalance.set(String.valueOf(playerModel.getBalance()));
    }
}