package be.ugent.objprog.ugentopoly.playertabpane;

import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class PlayerTabPane extends TabPane {

    public PlayerTabPane(List<PlayerModel> playerModels) {

        playerModels.forEach(playerModel -> {
            Tab tab = new Tab(playerModel.getPlayerName());
            tab.setClosable(false);
            tab.setContent(new PlayerTabInfoView(playerModel));
            getTabs().add(tab);
        });

        // TODO
        setMaxHeight(845);
        setMaxWidth(400);
    }

}