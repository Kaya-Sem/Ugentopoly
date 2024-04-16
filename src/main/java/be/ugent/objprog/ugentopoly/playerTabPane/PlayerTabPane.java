package be.ugent.objprog.ugentopoly.playerTabPane;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerTabPane extends TabPane implements InvalidationListener {
    private List<PlayerModel> playerModels;


    public PlayerTabPane(List<PlayerModel> players) {
        playerModels = players;
        playerModels.forEach(playerModel -> {
            playerModel.addListener(this);
        });

        // Create a tab for each player
        playerModels.forEach(playerModel -> {
            Tab tab = new Tab(playerModel.getPlayerName());
            tab.setClosable(false);

//            ObservableList<TileModel> observableList = FXCollections.observableArrayList(playerModel.getOwnedTiles());

            tab.setContent(new playerInfoView(playerModel));
            getTabs().add(tab);
        });

        setMaxHeight(845);
        setMaxWidth(400);

    }

    @Override
    public void invalidated(Observable observable) {
        GameModel model = (GameModel) observable;
        playerModels = model.getPlayerModels(); // dubious
    }

    private class playerInfoView extends VBox {
        private playerInfoView(PlayerModel model) {
            Label balance = new Label("balance: " + String.valueOf(model.getBalance()));

            // TODO add listview of tiles

            getChildren().addAll(balance);
        }
    }

}