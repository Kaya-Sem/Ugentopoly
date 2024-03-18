package be.ugent.objprog.ugentopoly.tiles;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.InputStream;
import java.util.Objects;

public class MiddleSection extends StackPane {
    private static final int SIZE = (845 / 13) * 9;

    public  MiddleSection(){

        setPrefSize(SIZE, SIZE);
        setMaxSize(SIZE, SIZE);
        setAlignment(Pos.CENTER); // Center content within the StackPane

        // Load the bottom image
        InputStream bottomImageStream = getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/gent_plan.jpg");
        Image bottomImage = new Image(Objects.requireNonNull(bottomImageStream));
        ImageView bottomImageView = new ImageView(bottomImage);
        bottomImageView.setViewport(new Rectangle2D(0, 0, SIZE, SIZE));

        // Load the top image
        InputStream topImageStream = getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/logo.png");
        Image topImage = new Image(Objects.requireNonNull(topImageStream));
        ImageView topImageView = new ImageView(topImage);
        //topImageView.setViewport(new Rectangle2D(0, 0, SIZE, SIZE));

        // Scale down the logo to fit within the bounds
        topImageView.setFitWidth(SIZE);
        topImageView.setFitHeight(SIZE * 0.15);
        topImageView.setRotate(45.0);

        getChildren().addAll(bottomImageView, topImageView);
    }
}
