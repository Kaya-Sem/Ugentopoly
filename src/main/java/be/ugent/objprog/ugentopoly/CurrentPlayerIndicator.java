package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.players.PlayerModel;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// TODO add current balance

public class CurrentPlayerIndicator extends VBox implements InvalidationListener {
    protected static final double SPACING = 20.0;
    protected static final double HEIGHT = 70.0;
    private final GameModel gameModel;
    private PlayerModel currentPlayer;
    private String playerName;
    private Image image;
    private String balance;

    public CurrentPlayerIndicator(GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameModel.addListener(this);
        currentPlayer = gameModel.getCurrentPlayerMove();

        playerName =currentPlayer.getPlayerName();
        image = currentPlayer.getBadgeImage();
        balance = String.valueOf(currentPlayer.getBalance());

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
        protected static final double BADGESIZE = 70.0;
        protected static final double DISTANCE = 20.0;

        private PlayerInfo() {

            Label playerNameLabel = new Label(playerName);
            playerNameLabel.setAlignment(Pos.CENTER);
            playerNameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20.0));

            Label balanceLabel = new Label("€" + balance);
            balanceLabel.setFont(Font.font("Consolas", FontWeight.THIN, 12.0));

            VBox vBox = new VBox(playerNameLabel, balanceLabel );
            vBox.setAlignment(Pos.CENTER);

            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(BADGESIZE);
            imageView.setFitWidth(BADGESIZE);

            getChildren().addAll(imageView, vBox);
            setAlignment(Pos.CENTER);
            setSpacing(DISTANCE);
        }
    }

    @Override
    public void invalidated(Observable observable) {
        GameModel model = (GameModel) observable;
        currentPlayer = model.getCurrentPlayerMove();
        playerName = currentPlayer.getPlayerName();
        image = currentPlayer.getBadgeImage();
        balance = String.valueOf(currentPlayer.getBalance());
    }

    public GameModel getGameModel() {
        return gameModel;
    }
}