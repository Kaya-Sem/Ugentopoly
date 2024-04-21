package be.ugent.objprog.ugentopoly.players;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

public class PlayerCreatorStage extends Stage {

    // HACK
    private static final ObservableList<ImageTextItem> badgeOptions = FXCollections.observableArrayList(
            new ImageTextItem("WINA", new Image("be/ugent/objprog/ugentopoly/assets/token1.png")),
            new ImageTextItem("V.T.K.", new Image("be/ugent/objprog/ugentopoly/assets/token2.png")),
            new ImageTextItem("CHEMICA", new Image("be/ugent/objprog/ugentopoly/assets/token3.png")),
            new ImageTextItem("FILOLOGICA", new Image("be/ugent/objprog/ugentopoly/assets/token4.png")),
            new ImageTextItem("GEOLOGICA", new Image("be/ugent/objprog/ugentopoly/assets/token5.png")),
            new ImageTextItem("V.B.K.", new Image("be/ugent/objprog/ugentopoly/assets/token6.png")),
            new ImageTextItem("V.E.K.", new Image("be/ugent/objprog/ugentopoly/assets/token7.png")),
            new ImageTextItem("V.L.K.", new Image("be/ugent/objprog/ugentopoly/assets/token8.png"))
    );

    protected static final double PADDING = 30.0;
    protected static final double SPACING = 50.0;
    protected static final double WIDTH = 1000.0;
    protected static final double HEIGHT = 400.0;

    final List<PlayerCustomizer> playerCustomizers;
    final Map<String, PlayerModel> players;
    final String balance;

    public PlayerCreatorStage(String startingBalance) {
        initModality(Modality.APPLICATION_MODAL);
        setAlwaysOnTop(true);
        setTitle("Add players");
        balance = startingBalance;
        players = new HashMap<>();

        Button startGame = new Button("Start game!");
        startGame.setOnAction(e -> {
            if (1 < players.size() && 5 > players.size()) {
                close();
            }
        });

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
}