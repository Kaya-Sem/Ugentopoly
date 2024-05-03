package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.dice.DicePanel;
import be.ugent.objprog.ugentopoly.GameController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class DiceRoller extends VBox {

    private final DicePanel dicePanel = new DicePanel();
    private final SimpleBooleanProperty isDisabled = new SimpleBooleanProperty();

    private static final double SPACING = 10.0;
    private static final double SIZE = 200.0;
    private final GameController controller;
    private int doubleRolledCounter = 0;
    private static final int MAXDOUBLEROLLS = 3;
    private int mostRecentRoll = 0;

    public DiceRoller(GameController controller) {
        this.controller = controller;
        Button rollButton = new Button("roll dice");
        rollButton.disableProperty().bind(isDisabled);

        rollButton.setOnAction(event ->  rollDice());

        setSpacing(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(dicePanel, rollButton);

        setMaxSize(SIZE, SIZE);
    }

    private void rollDice() {
        isDisabled.set(true);
        dicePanel.roll(this::handleRoll);
    }

    private void handleRoll(List<Integer> list) {
        Integer dice1 = list.getFirst();
        Integer dice2 = list.getLast();

        if (dice1.equals(dice2)) {
            doubleRolledCounter += 1;
            controller.addLog("dubbel gegooid!");

            if (doubleRolledCounter == MAXDOUBLEROLLS) {
                controller.addLog("Er werd " + MAXDOUBLEROLLS + " keer dubbel gegooid.\nDat wordt Overpoort!");
                controller.moveCurrentPlayerToJail();
                doubleRolledCounter = 0;
                controller.nextPlayer();
            }
            isDisabled.set(false);
            return;
        }

        doubleRolledCounter = 0;
        mostRecentRoll = dice1 + dice2;

        controller.actMove();
        isDisabled.set(false);
    }


    public void rollToGetFree() {
        isDisabled.set(false);

        // second child. Creating a class field for this button would be more robust
        Button rollButton = (Button) getChildren().get(1);

        // This approach was taken to not interupt the game flow. The button is only updated with new logic, for
        // when the player entered a "roll to get out of jail" event.
        rollButton.setOnAction(event -> {
            isDisabled.set(true);
            rollButton.setOnAction(e -> rollDice());

            dicePanel.roll(diceResult -> {
                Integer dice1 = diceResult.getFirst();
                Integer dice2 = diceResult.getLast();

                if (dice1.equals(dice2)) {
                    controller.freePlayerFromJail(dice1 + dice2);

                } else {
                    controller.addLog("Geen dubbel, je zal nog een nachtje moeten doordoen");
                }
                isDisabled.set(false);
                controller.nextPlayer();
            });
        });
    }

    public int getMostRecentRoll() {
        return mostRecentRoll;
    }

    public void setMostRecentRoll(int mostRecentRoll) {
        this.mostRecentRoll = mostRecentRoll;
    }

    public void setIsDisabled(Boolean value) {
        isDisabled.set(value);
    }

    public Boolean getIsDisabled() {
        return isDisabled.getValue();
    }
}