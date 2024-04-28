package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.dice.DicePanel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;

import static java.lang.String.valueOf;

public class DiceRoller extends VBox implements InvalidationListener {

    private final DiceModel diceModel;
    private final DicePanel dicePanel = new DicePanel();
    private final SimpleBooleanProperty disabled = new SimpleBooleanProperty();
    private final SimpleStringProperty mostRecentThrow = new SimpleStringProperty();

    private static final double SPACING = 10.0;
    private static final double SIZE = 300.0;

    public DiceRoller(DiceModel diceModel) {
        this.diceModel = diceModel;
        diceModel.addListener(this);

        // put in HBOX for more style options?
        Label recentThrow = new Label();
        recentThrow.textProperty().bind(mostRecentThrow);
        // NEEDSLOG in logging section

        Button rollButton = new Button("roll dice");
        rollButton.disableProperty().bind(disabled);
        rollButton.setOnAction(event -> dicePanel.roll(this::handleRoll));

        setSpacing(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(dicePanel, rollButton, recentThrow);

        setMaxSize(SIZE, SIZE);

    }

    private void handleRoll(List<Integer> list) {
        diceModel.setDisabled(true);

        Integer dice1 = list.get(0);
        Integer dice2 = list.getLast();

        diceModel.setMostRecentRoll(Integer.parseInt(valueOf(dice1 + dice2)));

        // HACK need a check to see if 3 times in a row same roll
        if (dice1.equals(dice2)) {
            diceModel.setDisabled(false);
            return;
            // NEEDSLOG
        }

        diceModel.getController().nextMove();
        diceModel.setDisabled(false);

    }

    public DiceModel getDiceModel() {
        return diceModel;
    }

    @Override
    public void invalidated(Observable observable) {
        disabled.set(diceModel.isDisabled());
        mostRecentThrow.set(valueOf(diceModel.getMostRecentRoll()));
    }
}