package be.ugent.objprog.ugentopoly.gameBoard;

import be.ugent.objprog.ugentopoly.TempTileSetup;
import be.ugent.objprog.ugentopoly.Ugentopoly;
import be.ugent.objprog.ugentopoly.bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.bars.VerticalBar;
import be.ugent.objprog.ugentopoly.tiles.tile.Tile;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Board extends GridPane {
    public static final double BOARD_SIZE = Ugentopoly.BOARD_SIZE;
    public static final int SMALL_TILES = 9;
    protected static final double MIDDLE_AREA_SIZE = (BOARD_SIZE / Ugentopoly.SMALL_TILES) * SMALL_TILES;

    public static final ToggleGroup TOGGLE_GROUP = new ToggleGroup();
    public static MiddleSection middleSection = new MiddleSection();

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

        // TODO fix
        // TileInitializer tileInitializer = new TileInitializer();
        // Map<String, ArrayList<? extends tile>> tileMap =
        // tileInitializer.initialiseTiles();

        // initialize tileholders
        HorizontalBar topRow = new HorizontalBar(TempTileSetup.upperBarTiles);
        HorizontalBar bottomRow = new HorizontalBar(TempTileSetup.bottomBarTiles);
        VerticalBar leftBar = new VerticalBar(TempTileSetup.leftBarTiles);
        VerticalBar rightBar = new VerticalBar(TempTileSetup.rightBarTiles);

        // apply rotation to tiles
        topRow.applyRotation(90);
        rightBar.applyRotation(180);
        bottomRow.applyRotation(270);

        // TODO make positions constant
        add(topRow, 1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        add(middleSection, 1, 1);

        // TODO make positions constant, for better readability
        System.out.println(TempTileSetup.cornerTiles);
        add(TempTileSetup.cornerTiles.get(0), 0, 2); // bottom left
        add(TempTileSetup.cornerTiles.get(1), 0, 0); // top left
        add(TempTileSetup.cornerTiles.get(2), 2, 0); // top right
        add(TempTileSetup.cornerTiles.get(3), 2, 2); // bottom right

    }
}
