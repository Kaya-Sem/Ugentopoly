package be.ugent.objprog.ugentopoly.players;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.jdom2.Text;

public class ImageTextListCell extends ListCell<ImageTextItem> {
    protected static final double IMAGESIZE = 60.0;
    protected static final double PADDING = 5.0;
    protected static final double SPACING = 10.0;

    @Override
    protected void updateItem(ImageTextItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || null == item) {
            setText(null);
            setGraphic(null);
        } else {

            ImageView view = new ImageView(item.image());
            view.setFitWidth(IMAGESIZE);
            view.setFitHeight(IMAGESIZE);
            view.setPreserveRatio(true);

            HBox hBox = new HBox(SPACING);
            hBox.setPadding(new Insets(PADDING));

            Label textLabel = new Label(item.text());

            hBox.getChildren().addAll(view, textLabel);
            setGraphic(hBox);
        }
    }
}