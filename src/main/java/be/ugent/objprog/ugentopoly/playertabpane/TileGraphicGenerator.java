package be.ugent.objprog.ugentopoly.playertabpane;

import be.ugent.objprog.ugentopoly.tiles.tileModels.TileModel;
import javafx.scene.image.ImageView;

@FunctionalInterface
interface TileGraphicGenerator {
    ImageView generate(TileModel tile);
}