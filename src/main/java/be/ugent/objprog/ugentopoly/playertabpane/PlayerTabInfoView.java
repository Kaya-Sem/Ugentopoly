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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.beans.binding.Bindings;


public class PlayerTabInfoView extends VBox implements InvalidationListener {

    private final PlayerModel playerModel;
    private final StringProperty playerBalance = new SimpleStringProperty();
    private final StringProperty playerPosition = new SimpleStringProperty();
    private final StringProperty playerFreeJailCards = new SimpleStringProperty();

    public PlayerTabInfoView(PlayerModel playerModel) {
        this.playerModel = playerModel;
        playerModel.addListener(this);

        ListView<TileModel> playerOwnedTiles = new ListView<>(playerModel.getOwnedTiles());
        playerOwnedTiles.setCellFactory(listView -> new TileCell());
        playerOwnedTiles.setFocusTraversable(false);
        playerOwnedTiles.setMouseTransparent(true);

        HBox title = new HBox(getPlayerNameLabel(), getLabel(playerBalance, "€"));
        title.setSpacing(10);
        title.setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(
                title,
                getLabel(playerPosition, "Positie: "),
                getLabel(playerFreeJailCards, "Jail kaarten: "),
                playerOwnedTiles);
        setPadding(new Insets(5));
        setSpacing(5);
    }

    private Label getPlayerNameLabel() {
        Label playerName = new Label(playerModel.getName());
        playerName.setFont(Font.font("Arial", FontWeight.BOLD, 17)); // TODO
        playerName.setAlignment(Pos.CENTER);
        return playerName;
    }

    private static Label getLabel(StringProperty property, String pretext) {
        Label newLabel = new Label();
        newLabel.textProperty().bind(Bindings.createStringBinding(
                () -> pretext + property.get(), property
        ));
        return newLabel;
    }

    @Override
    public void invalidated(Observable observable) {
        playerBalance.set(String.valueOf(playerModel.getBalance()));
        playerPosition.set(String.valueOf(playerModel.getPosition()));
        playerFreeJailCards.set(String.valueOf(playerModel.getLeaveJailCards().size()));
    }
}