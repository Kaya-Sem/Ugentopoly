package be.ugent.objprog.ugentopoly.players;

import be.ugent.objprog.ugentopoly.CustomImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

public class PlayerCreatorStage extends Stage {

    private boolean cancelled = true; // Default to true, assuming cancel until proven otherwise

    private static final ObservableList<ImageTextItem> badgeOptions = FXCollections.observableArrayList(
            new ImageTextItem("WINA", new CustomImage("token1.png")),
            new ImageTextItem("V.T.K.", new CustomImage("token2.png")),
            new ImageTextItem("CHEMICA", new CustomImage("token3.png")),
            new ImageTextItem("FILOLOGICA", new CustomImage("token4.png")),
            new ImageTextItem("GEOLOGICA", new CustomImage("token5.png")),
            new ImageTextItem("V.B.K.", new CustomImage("token6.png")),
            new ImageTextItem("V.E.K.", new CustomImage("token7.png")),
            new ImageTextItem("V.L.K.", new CustomImage("token8.png"))
    );

    protected static final double PADDING = 30.0;
    protected static final double SPACING = 50.0;
    protected static final double WIDTH = 1000.0;
    protected static final double HEIGHT = 400.0;

    final List<PlayerCustomizer> playerCustomizers;
    final Map<String, PlayerModel> players;
    final String balance;

    public PlayerCreatorStage(Stage stage, String startingBalance) {
        initModality(Modality.NONE);
        setAlwaysOnTop(true);

        setTitle("Add players");
        balance = startingBalance;
        players = new HashMap<>();

        setOnCloseRequest(event -> {
            cancelled = true;
            stage.close();
        });

        Button startGame = new Button("Start game!");
        startGame.setOnAction(e -> {
            if (players.size() > 1 && players.size() < 5) {
                cancelled = false;
                close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(this);
                alert.setTitle("Not Enough Players");
                alert.setHeaderText(null);
                alert.setContentText("Please add atleast 2 players");
                alert.showAndWait();
            }
        });

        // TODO extract to constants, or new property file?
        playerCustomizers = List.of(new PlayerCustomizer[]{
                new PlayerCustomizer(this, "Kris Koolsaet", "1"),
                new PlayerCustomizer(this, "Bart De Bruyn", "2"),
                new PlayerCustomizer(this, "Peter Dawyndt", "3"),
                new PlayerCustomizer(this, "Veerle Fack", "4")
        });

        playerCustomizers.forEach(customizer -> customizer.getBadgeComboBox().getItems().addAll(badgeOptions));
        playerCustomizers.forEach(item -> item.getBadgeComboBox().setCellFactory(param -> new ImageTextListCell()));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(playerCustomizers);
        hBox.setSpacing(SPACING);
        hBox.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.setPadding(new Insets(PADDING));
        root.getChildren().addAll(hBox, startGame);
        StackPane.setAlignment(startGame, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        setScene(scene);
    }

    public List<PlayerModel> showAndWaitForPlayers() {
        showAndWait();
        return new ArrayList<>(players.values());
    }

    public boolean isCancelled() {
        return cancelled;
    }
}