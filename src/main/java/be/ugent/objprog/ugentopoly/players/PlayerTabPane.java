package be.ugent.objprog.ugentopoly.players;

import be.ugent.objprog.ugentopoly.GameModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

import java.util.List;

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