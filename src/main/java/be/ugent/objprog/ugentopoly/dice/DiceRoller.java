package be.ugent.objprog.ugentopoly.dice;

import be.ugent.objprog.dice.DicePanel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.beans.binding.Bindings;

import java.util.List;

public class DiceRoller extends VBox implements InvalidationListener {

    private final DiceModel diceModel;
    private final DicePanel dicePanel = new DicePanel();
    private final SimpleBooleanProperty clickable = new SimpleBooleanProperty();
    private final SimpleStringProperty mostRecentThrow = new SimpleStringProperty();

    private static final double SPACING = 10.0;
    private static final double SIZE = 300.0;

    public DiceRoller(DiceModel diceModel) {
        this.diceModel = diceModel;

        // put in HBOX for more style options?
        Label recentThrow = new Label();
        recentThrow.textProperty().bind(mostRecentThrow);

        Button rollButton = new Button("roll dice");
        rollButton.disableProperty().bind(clickable);
        rollButton.setOnAction(event -> dicePanel.roll(list -> diceModel.getController().rollDice(list)));

        setSpacing(SPACING);
        setAlignment(Pos.CENTER);
        getChildren().addAll(new DicePanel(), rollButton, recentThrow);

        setMaxSize(SIZE, SIZE);

    }

    public DiceModel getDiceModel() {
        return diceModel;
    }

    @Override
    public void invalidated(Observable observable) {
        DiceModel model = (DiceModel) observable;
        clickable.set(model.isRollable());
        mostRecentThrow.set(model.getMostRecentRoll());
    }
}