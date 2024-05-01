package be.ugent.objprog.ugentopoly.tiles.tileModels;

import be.ugent.objprog.ugentopoly.CustomObservable;
import be.ugent.objprog.ugentopoly.DisplayCardController;
import be.ugent.objprog.ugentopoly.GameModel;
import be.ugent.objprog.ugentopoly.factories.PropertyFactory;
import be.ugent.objprog.ugentopoly.players.Pion;
import be.ugent.objprog.ugentopoly.tiles.tileCards.TemplateCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class TileModel extends CustomObservable {

    protected final String id;
    protected final int position;
    protected String tileName;
    protected final List<Pion> pionnen = new ArrayList<>();
    protected DisplayCardController controller = null;

    protected TemplateCard card = null;

   protected TileModel(String tileID, int tilePosition){
        id = tileID;
        position = tilePosition;
        tileName = PropertyFactory.getString(tileID);
    }

    public DisplayCardController getController() {
       return controller;
    }

    public TemplateCard getCard() {
       return card;
    }

    public Consumer<GameModel> getPlayerTileInteraction() {
        throw new IllegalStateException("base TileModel interaction called");
    }

    public void executePlayerTileInteraction(GameModel gameModel) {
       getPlayerTileInteraction().accept(gameModel);
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

    public void setController(DisplayCardController controller) {
       this.controller = controller;
    }

    protected void setCard(TemplateCard card) {
       this.card = card;
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