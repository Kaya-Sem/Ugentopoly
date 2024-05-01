package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.dice.DicePanel;
import be.ugent.objprog.ugentopoly.GameController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

import static java.lang.String.valueOf;

public class DiceRoller extends VBox {

    private final DicePanel dicePanel = new DicePanel();
    private final SimpleBooleanProperty disabled = new SimpleBooleanProperty();

    private static final double SPACING = 10.0;
    private static final double SIZE = 300.0;
    private final GameController controller;
    private int doubleRolledCounter = 0;
    private static final int MAXDOUBLEROLLS = 3;
    private int mostRecentRoll = 0;

    public DiceRoller(GameController controller) {
        this.controller = controller;
        Button rollButton = new Button("roll dice");
        rollButton.disableProperty().bind(disabled);
        rollButton.setOnAction(event -> {
            disabled.set(true);
            dicePanel.roll(this::handleRoll
            );
        });

        setSpacing(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(dicePanel, rollButton);

        setMaxSize(SIZE, SIZE);
    }

    public void setDisabled(Boolean value) {
        disabled.set(value);
    }

    public Boolean getDisabled() {
        return disabled.getValue();
    }

    private void handleRoll(List<Integer> list) {
        Integer dice1 = list.getFirst();
        Integer dice2 = list.getLast();

        if (dice1.equals(dice2)) {
            doubleRolledCounter += 1;
            controller.addLog("dubbel gegooid!");

            if (MAXDOUBLEROLLS == doubleRolledCounter) {
                controller.addLog("Er werd " + MAXDOUBLEROLLS + " keer dubbel gegooid.\nDat wordt Overpoort!");
                controller.moveCurrentPlayerToJail();
                doubleRolledCounter = 0;
                controller.nextPlayer();
            }

            disabled.set(false);
            return;
        }

        doubleRolledCounter = 0;
        mostRecentRoll = dice1 + dice2;

        controller.nextMove();
        disabled.set(false);
    }

    public void rollToGetFree() {
        disabled.set(Boolean.FALSE);

        dicePanel.roll(diceResult -> {
            Integer dice1 = diceResult.getFirst();
            Integer dice2 = diceResult.getLast();

            if (dice1.equals(dice2)) {
                controller.freePlayerFromJail(dice1 + dice2);
            } else {
                controller.addLog("Geen dubbel, je zal nog een nachtje moeten doordoen");
                controller.nextPlayer();
            }
        });

        disabled.set(Boolean.TRUE);
    }

    public int getMostRecentRoll() {
        return mostRecentRoll;
    }

    public void setMostRecentRoll(int mostRecentRoll) {
        this.mostRecentRoll = mostRecentRoll;
    }
}