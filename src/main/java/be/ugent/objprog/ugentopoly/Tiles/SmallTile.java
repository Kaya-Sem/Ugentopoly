package be.ugent.objprog.ugentopoly.Tiles;

public class SmallTile extends Tile {

    protected int rotatie;

    public SmallTile(int rotatie) {
        this.rotatie = rotatie;
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);

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
