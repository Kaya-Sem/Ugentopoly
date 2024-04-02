package be.ugent.objprog.ugentopoly.Tiles.Tile;

import be.ugent.objprog.ugentopoly.CustomButtonHandler;
import be.ugent.objprog.ugentopoly.TileButton;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;

public abstract class Tile extends StackPane {
    public final static double LONG_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES) * 2);
    public final static double SHORT_SIDE = ((Ugentopoly.BOARD_SIZE / Ugentopoly.SMALL_TILES));

    Record companion;
    String id;
    final TileButton tileButton = new TileButton();

    public Tile(Record companion, String id){
        this.companion = companion;
        this.id = id;

        tileButton.setOnAction(event -> handleButton(event, companion));
    }

    public Tile(String id) {
        this.id = id;

        tileButton.setOnAction(event -> handleButton(event, companion));
    }

    protected abstract void setup(String id);

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

    private void handleButton(ActionEvent event, Record companion) {
        System.err.println("Button clicked: " + event.getEventType() + " " + event.hashCode() + "\n" + companion);
        CustomButtonHandler.updateDisplayedCard(companion);
    }
}

