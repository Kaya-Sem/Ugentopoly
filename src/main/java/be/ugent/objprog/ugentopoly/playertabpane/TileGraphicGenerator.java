package be.ugent.objprog.ugentopoly.playertabpane;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

@FunctionalInterface
interface TileGraphicGenerator {
    ImageView generate(TileModel tile);
}