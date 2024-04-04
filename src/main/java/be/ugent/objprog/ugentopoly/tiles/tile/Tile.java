package be.ugent.objprog.ugentopoly.tiles.tile;

import be.ugent.objprog.ugentopoly.CustomButtonHandler;
import be.ugent.objprog.ugentopoly.TileButton;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.tileCards.TemplateCard;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

public class Tile extends StackPane {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));
    private static final double OFFSET = 32.5;

    final Record companion;
    final String id;
    protected TemplateCard card;

    protected TileButton tileButton = new TileButton();

    public Tile(Record companion, String id){
        this.companion = companion;
        this.id = id;
        this.tileButton.setOnAction(this::handleButton);
    }

    protected void setup(String id) {}

    public void applyRotation(double angle){
        setTranslateX(getWidth() / 2);
        setTranslateY(getHeight() / 2);
        setRotate(angle);
        if (angle == 90 || angle == 270) {
            setTranslateX(- OFFSET);
            setTranslateY(OFFSET);
        }
    }

    protected void handleButton(ActionEvent event) {
        System.err.println(this.companion);
        TileButton source  = (TileButton) event.getSource();
        boolean isSelected = source.isSelected();


        CustomButtonHandler.updateDisplayedCard((isSelected) ? card : null);
    }
}