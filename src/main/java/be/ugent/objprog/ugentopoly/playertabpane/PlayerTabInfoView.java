package be.ugent.objprog.ugentopoly.playertabpane;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerTabInfoView extends VBox implements InvalidationListener {

    private final PlayerModel playerModel;
    private final StringProperty playerBalance = new SimpleStringProperty();

    public PlayerTabInfoView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        playerModel.addListener(this);

        playerBalance.set(String.valueOf(this.playerModel.getBalance()));

        Label balance = new Label();
        balance.textProperty().bind(playerBalance);

        // TODO add player position and style balance better
        // TODO add listview of tiles

        // ObservableList<TileModel> observableList = FXCollections.observableArrayList(playerModel.getOwnedTiles());
        getChildren().addAll(balance);
    }

    @Override
    public void invalidated(Observable observable) {
        // TODO
        playerBalance.set(String.valueOf(playerModel.getBalance()));
    }
}