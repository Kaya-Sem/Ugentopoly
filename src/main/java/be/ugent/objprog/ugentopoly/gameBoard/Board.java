package be.ugent.objprog.ugentopoly.gameBoard;

import be.ugent.objprog.ugentopoly.TileInitializer;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.bars.VerticalBar;
import be.ugent.objprog.ugentopoly.factories.TileFactory;
import be.ugent.objprog.ugentopoly.parsers.XMLParser;
import be.ugent.objprog.ugentopoly.tiles.tileViews.Tile;
import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import be.ugent.objprog.ugentopoly.tiles.tileViews.cornerTiles.CornerTile;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

// TODO create a separate MVC board model with the data

import java.util.Map;

public class Board extends GridPane {
    public static final double BOARD_SIZE = Ugentopoly.BOARD_SIZE;
    public static final int SMALL_TILES = 9;
    protected static final double MIDDLE_AREA_SIZE = (BOARD_SIZE / Ugentopoly.SMALL_TILES) * SMALL_TILES;

    public static final ToggleGroup TOGGLE_GROUP = new ToggleGroup();
    public static final MiddleSection middleSection = new MiddleSection();

    private final TileModel[] tileModels;

    public Board() {
        setPrefSize(BOARD_SIZE, BOARD_SIZE);
        setMaxHeight(BOARD_SIZE);
        setMaxWidth(BOARD_SIZE);
        setAlignment(Pos.CENTER);

        // TODO put constraints in constant
        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(Tile.LONG_SIDE), // Left bar column
                new ColumnConstraints(MIDDLE_AREA_SIZE) // Mid section column
        );

        getRowConstraints().addAll( // Set row constraints
                new RowConstraints(Tile.LONG_SIDE), // Top row
                new RowConstraints(MIDDLE_AREA_SIZE) // Mid-section row
        );

        // retrieve a map of 4 parts + all models

        XMLParser parser = new XMLParser();
        TileFactory factory = new TileFactory(parser.areaColors());
        TileInitializer tileInitializer = new TileInitializer(parser, factory);

        Map<String, Object[]> tileMap = tileInitializer.TileModelInitializer();

        this.tileModels = (TileModel[]) tileMap.get("models");

        // initialize tileholders
        HorizontalBar topRow = new HorizontalBar((Tile[]) tileMap.get("top"));
        HorizontalBar bottomRow = new HorizontalBar((Tile[]) tileMap.get("bottom"));
        VerticalBar leftBar = new VerticalBar((Tile[]) tileMap.get("left"));
        VerticalBar rightBar = new VerticalBar((Tile[]) tileMap.get("right"));

        // TODO can be done in the initializer? extra constructor
        topRow.applyRotation(90);
        rightBar.applyRotation(180);
        bottomRow.applyRotation(270);

        // TODO make positions constant
        add(topRow, 1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        add(middleSection, 1, 1);

        add((CornerTile) tileMap.get("corners")[0], 0, 2); // bottom left
        add((CornerTile) tileMap.get("corners")[1], 0, 0); // top left
        add((CornerTile) tileMap.get("corners")[2], 2, 0); // top right
        add((CornerTile) tileMap.get("corners")[3], 2, 2); // bottom right

    }

    public TileModel[] getTileModels() {
        return tileModels;
    }
}