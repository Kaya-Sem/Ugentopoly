package be.ugent.objprog.ugentopoly.tiles.tile;

import be.ugent.objprog.ugentopoly.CustomButtonHandler;
import be.ugent.objprog.ugentopoly.TileButton;
import be.ugent.objprog.ugentopoly.tileCards.TemplateCard;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));

    final Record companion;
    final String id;
    protected TemplateCard card;

    protected final TileButton tileButton = new TileButton();

    public Tile(Record companion, String id){
        this.companion = companion;
        this.id = id;
        this.tileButton.setOnAction(this::handleButton);
    }

    protected void setup(String id) {}

    public void applyRotation(double angle){
        // TODO fix rotation
        // set pivot points as constant
        setTranslateX(getWidth() / 2);
        setTranslateY(getHeight() / 2);
        setRotate(angle);
        if (angle == 90 || angle == 270) {
            setTranslateX(-32.5);
            setTranslateY(32.5);
        }
    }

    protected void handleButton(ActionEvent event) {
        System.err.println("Button clicked: " + this.companion);
        TileButton source  = (TileButton) event.getSource();
        boolean isSelected = source.isSelected();

        CustomButtonHandler.updateDisplayedCard((isSelected) ? card : null);
    }
}