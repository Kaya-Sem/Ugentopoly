package be.ugent.objprog.ugentopoly.logging;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class LogListView extends ListView {
    protected static final int WIDTH = 300;
    protected static final int HEIGHT = 200;

    public LogListView(ObservableList<LogElement> logs) {
        super(logs);
        setSelectionModel(null);
        logs.addListener(this::onChanged);
        setMinWidth(WIDTH);
        setMaxHeight(HEIGHT);
    }

    // Always scroll down to the most recently added element, so the user does not have to scroll manually.
    // this is automatic in textfield, but would offer less control over elements
    private void onChanged(ListChangeListener.Change<? extends LogElement> change) {
    while (change.next()) {
        if (change.wasAdded()) {
            scrollTo(change.getList().size() - 1);
        }
    }
}
}