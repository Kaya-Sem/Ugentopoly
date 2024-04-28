package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.parsers.PropertyLoader;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.players.PlayerModel;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class TileModel extends CustomObservable {

    protected final String id;
    protected final int position;
    protected String tileName;
    protected final List<Pion> pionnen = new ArrayList<>();

    protected TemplateCard card = null;

   protected TileModel(String tileID, int tilePosition){
        id = tileID;
        position = tilePosition;
        tileName = PropertyLoader.getLabel(tileID); // TODO maybe move to factory?
    }

    public Consumer<GameModel> getPlayerTileInteraction() {
        throw new IllegalStateException("base TileModel interaction called");
    }

    public void addPion(Pion pion) {
        if (!pionnen.contains(pion)) {
            pionnen.add(pion);
           fireInvalidationEvent();
        }
    }

    public void removePion(Pion pion) {
        if (pionnen.contains(pion)) {
            pionnen.remove(pion);
            fireInvalidationEvent();
        }
    }

    public List<Pion> getPionnen() {
        return Collections.unmodifiableList(pionnen);
    }

    public String getId() {
        return id;
    }

    public String getTileName() {
       return tileName;
    }

    public int getPosition() {
        return position;
    }

}