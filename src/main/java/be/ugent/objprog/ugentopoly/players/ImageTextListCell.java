package be.ugent.objprog.ugentopoly.players;

import be.ugent.objprog.ugentopoly.CustomImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ImageTextListCell extends ListCell<ImageTextItem> {
    protected static final double IMAGESIZE = 60.0;
    protected static final double PADDING = 5.0;
    protected static final double SPACING = 10.0;

    @Override
    protected void updateItem(ImageTextItem item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {

            ImageView view = new CustomImageView(IMAGESIZE, IMAGESIZE, item.image());

            HBox hBox = new HBox(SPACING);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(PADDING));

            Label textLabel = new Label(item.text());

            hBox.getChildren().addAll(view, textLabel);
            setGraphic(hBox);
        }
    }
}