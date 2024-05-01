package be.ugent.objprog.ugentopoly.playertabpane;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.List;

public class PlayerTabPane extends TabPane {

    public PlayerTabPane(List<PlayerModel> playerModels) {
        playerModels.forEach(playerModel -> {
            Tab tab = new Tab(playerModel.getName());
            tab.setClosable(false);
            tab.setContent(new PlayerTabInfoView(playerModel));
            getTabs().add(tab);
        });
    }

}