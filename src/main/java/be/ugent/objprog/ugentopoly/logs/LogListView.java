package be.ugent.objprog.ugentopoly.logs;

import be.ugent.objprog.ugentopoly.logging.LogElement;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class LogListView extends ListView {
    public LogListView(ObservableList<LogElement> logs) {
        super(logs);
        setSelectionModel(null);
        logs.addListener(this::onChanged);
        setMinWidth(200);
    }

    // Always scroll down to the most recently added element, so the user does not have to scroll manually.
    private void onChanged(ListChangeListener.Change<? extends LogElement> change) {
    while (change.next()) {
        if (change.wasAdded()) {
            scrollTo(change.getList().size() - 1);
        }
    }
}
}