package be.ugent.objprog.ugentopoly.gameBoard;

// TODO create a separate MVC board model with the data

import java.util.List;
import java.util.Map;

import be.ugent.objprog.ugentopoly.gameBoard.bars.HorizontalBar;
import be.ugent.objprog.ugentopoly.gameBoard.bars.VerticalBar;
import be.ugent.objprog.ugentopoly.tiles.tileViews.TileView;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Board extends GridPane implements InvalidationListener {

    private final BoardModel boardModel;
    public final MiddleSection middleSection;

    public Board(BoardModel boardModel, Map<String, Object[]> tileViews) {
        this.boardModel = boardModel;
        this.boardModel.addListener(this);
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

        // HACK create constructor with preapplied rotation
        // initialize tileholders // HACK fixx issue with casting...
        HorizontalBar topRow = new HorizontalBar(List.of((TileView[]) tileViews.get("top")));
        HorizontalBar bottomRow = new HorizontalBar(List.of((TileView[]) tileViews.get("bottom")));
        VerticalBar leftBar = new VerticalBar(List.of((TileView[]) tileViews.get("left")));
        VerticalBar rightBar = new VerticalBar(List.of((TileView[]) tileViews.get("right")));

        topRow.applyRotation(BoardModel.TOPANGLE);
        rightBar.applyRotation(BoardModel.RIGHTANGLE);
        bottomRow.applyRotation(BoardModel.BOTTOMANGLE);

        add(topRow, 1, 0);
        add(rightBar, 2, 1);
        add(leftBar, 0, 1);
        add(bottomRow, 1, 2);

        add(middleSection, 1, 1);

        add((Node) tileViews.get("corners")[0], 0, 2); // bottom left
        add((Node) tileViews.get("corners")[1], 0, 0); // top left
        add((Node) tileViews.get("corners")[2], 2, 0); // top right
        add((Node) tileViews.get("corners")[3], 2, 2); // bottom right
    }

    @Override
    // OPTIMIZE
    public void invalidated(Observable observable) {}
}