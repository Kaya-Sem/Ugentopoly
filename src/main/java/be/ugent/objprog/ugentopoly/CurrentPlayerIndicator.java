package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CurrentPlayerIndicator extends VBox implements InvalidationListener {
    protected static final double SPACING = 20.0;
    protected static final double HEIGHT = 70.0;
    private final GameModel gameModel;
    private PlayerModel currentPlayer;

    private final SimpleStringProperty playerName = new SimpleStringProperty();
    private final SimpleObjectProperty<Image> image = new SimpleObjectProperty<>();
    private final StringProperty balance = new SimpleStringProperty();

    public CurrentPlayerIndicator(GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameModel.addListener(this);
        currentPlayer = gameModel.getCurrentPlayer();

        playerName.set(currentPlayer.getName());
        image.set(currentPlayer.getBadgeImage());
        balance.set(String.valueOf(currentPlayer.getBalance()));

        Label text = new Label("Now Playing:");
//        text.getStylesheets().add("medium-title"); TODO cannot load stylesheets?
        text.setFont(Font.font("Arial", FontWeight.MEDIUM, 12.0));

        PlayerInfo playerInfo = new PlayerInfo();

       getChildren().addAll(text, playerInfo);
       setAlignment(Pos.TOP_CENTER);
       setSpacing(SPACING);
       setPadding(new Insets(SPACING));

       setMaxHeight(HEIGHT);
    }

    private class PlayerInfo extends HBox{

        private PlayerInfo() {

            Label playerNameLabel = new Label();
            playerNameLabel.textProperty().bind(playerName);
            playerNameLabel.setAlignment(Pos.CENTER);
            playerNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20.0));

            Label balanceLabel = new Label();
            balanceLabel.textProperty().bind(Bindings.createStringBinding(
                    () -> "€" + balance.getValue(),
                    balance
            ));

            balanceLabel.setFont(Font.font("Consolas", FontWeight.THIN, 12.0));

            VBox vBox = new VBox(playerNameLabel, balanceLabel );
            vBox.setAlignment(Pos.CENTER);

            ImageView imageView = new CustomImageView(HEIGHT);
            imageView.imageProperty().bind(image);

            getChildren().addAll(imageView, vBox);
            setAlignment(Pos.CENTER);
            setSpacing(SPACING);
        }
    }

    @Override
    public void invalidated(Observable observable) {
        currentPlayer = gameModel.getCurrentPlayer();
        playerName.set(currentPlayer.getName());
        image.set(currentPlayer.getBadgeImage());
        balance.set(String.valueOf(currentPlayer.getBalance()));
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}