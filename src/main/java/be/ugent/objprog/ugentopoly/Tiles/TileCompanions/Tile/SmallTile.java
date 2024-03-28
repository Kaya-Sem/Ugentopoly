package be.ugent.objprog.ugentopoly.Tiles.TileCompanions.Tile;

public class SmallTile extends Tile {

    protected int rotatie;

    // HACK second constructor to get around rotation. fix with a setRotation
    public SmallTile() {

    }

    public SmallTile(Record companion, String id) {
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);

        int rotatie = 0;

        // set pivot points
        setTranslateX(getWidth() / 2);
        setTranslateY(getHeight() / 2);
        setRotate(rotatie);
        if (rotatie == 90 || rotatie == 270) {

            setTranslateX(-32.5);
            setTranslateY(32.5);
        }
    }


}
