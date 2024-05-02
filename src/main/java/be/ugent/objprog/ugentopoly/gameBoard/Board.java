package be.ugent.objprog.ugentopoly.gameBoard;

import java.util.List;

import be.ugent.objprog.ugentopoly.gameBoard.bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.gameBoard.bars.VerticalBar;
import be.ugent.objprog.ugentopoly.tiles.InitializedTilesObject;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Board extends GridPane {

    public final MiddleSection middleSection;

    public Board(BoardModel boardModel, InitializedTilesObject tileViews) {
        double size = BoardModel.BOARD_SIZE;
        middleSection = new MiddleSection(boardModel);
        setPrefSize(size, size);
        setMaxHeight(size);
        setMaxWidth(size);
        setAlignment(Pos.CENTER);

        getColumnConstraints().addAll( // Set column constraints
                new ColumnConstraints(TileView.LONG_SIDE), // Left bar column
                new ColumnConstraints(BoardModel.MIDDLE_AREA_SIZE) // Mid section column
        );

        getRowConstraints().addAll( // Set row constraints
                new RowConstraints(TileView.LONG_SIDE), // Top row
                new RowConstraints(BoardModel.MIDDLE_AREA_SIZE) // Mid-section row
        );

        HorizontalBar topRow = new HorizontalBar(List.of(tileViews.topTilesViewArray()), BoardModel.TOPANGLE);
        HorizontalBar bottomRow = new HorizontalBar(List.of(tileViews.bottomTilesViewArray()), BoardModel.BOTTOMANGLE);
        VerticalBar leftBar = new VerticalBar(List.of(tileViews.leftTilesViewArray()));
        VerticalBar rightBar = new VerticalBar(List.of(tileViews.rightTilesViewArray()), BoardModel.RIGHTANGLE);

        add(topRow, 1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        add(middleSection, 1, 1);

        add(tileViews.cornerTilesViewArray()[0], 0, 2); // bottom left
        add(tileViews.cornerTilesViewArray()[1], 0, 0); // top left
        add(tileViews.cornerTilesViewArray()[2], 2, 0); // top right
        add(tileViews.cornerTilesViewArray()[3], 2, 2); // bottom right
    }

}