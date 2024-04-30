package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.dice.DicePanel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

import static java.lang.String.valueOf;

public class DiceRoller extends VBox implements InvalidationListener {

    private final DiceModel diceModel;
    private final DicePanel dicePanel = new DicePanel();
    private final SimpleBooleanProperty disabled = new SimpleBooleanProperty();

    private static final double SPACING = 10.0;
    private static final double SIZE = 300.0;
    private int doubleRolledCounter = 0;
    private static final int MAXDOUBLEROLLS = 3;

    public DiceRoller(DiceModel diceModel) {
        this.diceModel = diceModel;
        diceModel.addListener(this);

        Button rollButton = new Button("roll dice");
        rollButton.disableProperty().bind(disabled);
        rollButton.setOnAction(event -> {
            diceModel.setDisabled(true);
            dicePanel.roll(this::handleRoll);
        });

        setSpacing(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(dicePanel, rollButton);

        setMaxSize(SIZE, SIZE);
    }

    private void handleRoll(List<Integer> list) {
        Integer dice1 = list.getFirst();
        Integer dice2 = list.getLast();



        if (dice1.equals(dice2)) {
            diceModel.getGameController().addLog("a double was rolled!");
            if (MAXDOUBLEROLLS == doubleRolledCounter) {
                diceModel.getGameController().moveCurrentPlayerToJail();
                doubleRolledCounter = 0;
                diceModel.getGameController().nextPlayer();
                diceModel.getGameController().addLog("3 doubles in a row, went to jail!");
            } else {
            doubleRolledCounter += 1;
            diceModel.setDisabled(false);
            }
            return;
        }

        diceModel.setMostRecentRoll(dice1 + dice2);

        diceModel.getGameController().nextMove();
        diceModel.setDisabled(false);
    }

    public DiceModel getDiceModel() {
        return diceModel;
    }

    @Override
    public void invalidated(Observable observable) {
        disabled.set(diceModel.isDisabled());
    }
}