package be.ugent.objprog.ugentopoly.tiles.tileCards;

import be.ugent.objprog.ugentopoly.CustomImageView;
import be.ugent.objprog.ugentopoly.tiles.tileModels.UtilityTileModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class UtilityCard extends HorizontalCard {
    private static final double IMAGEHEIGHT = HEIGHT - 10;
    private static final double IMAGEWIDTH = HEIGHT - 10;

    public UtilityCard(UtilityTileModel model){
        ImageView imageView = new CustomImageView(IMAGEHEIGHT, IMAGEWIDTH, model.getImage());

        Label amount = new Label("€" + model.getCost());
        Label ownerLabel = new Label();
        ownerLabel.textProperty().bind(model.ownerProperty());

        ownerLabel.getStyleClass().add("owner-label");
        amount.getStyleClass().add("bold-label-large");

        VBox vBox = new VBox(imageView, ownerLabel, amount);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        getChildren().addAll(vBox);
    }
}