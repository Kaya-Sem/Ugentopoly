package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.dice.DicePanel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public final class DiceRoller extends VBox implements InvalidationListener {

    private final DiceModel diceModel;

    protected static final double SPACING = 10.0;
    protected static final double SIZE = 300.0;
    private final DicePanel dicePanel = new DicePanel();
    private StringProperty mostRecentRoll = new SimpleStringProperty();

    public DiceRoller(DiceModel diceModel) {
        this.diceModel = diceModel;
        diceModel.addListener(this);
        Button rollButton = new Button("Gooi dobbelstenen!");
        Label recentThrow = new Label();

        recentThrow.textProperty().bind(mostRecentRoll);


        rollButton.setOnAction(event -> {
            rollButton.setDisable(true);
            dicePanel.roll(list -> {
                diceModel.setMostRecentRoll(list);
                rollButton.setDisable(false);

            });

        });


        setSpacing(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(dicePanel, rollButton, recentThrow);

        setMaxSize(SIZE, SIZE);

    }

    @Override
    public void invalidated(Observable observable) {
        DiceModel model = (DiceModel) observable;
        mostRecentRoll.set(model.getMostRecentRoll().toString());

    }
}