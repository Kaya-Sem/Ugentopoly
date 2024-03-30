package be.ugent.objprog.ugentopoly.Tiles.Tile;

public abstract class SmallTile extends Tile {

    protected int rotatie;

    public SmallTile(Record companion, String id) {
        super(companion, id);
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);

        int rotatie = 0;

        // TODO fix rotation
        // set pivot points
        setTranslateX(getWidth() / 2);
        setTranslateY(getHeight() / 2);
        setRotate(rotatie);
        if (rotatie == 90 || rotatie == 270) {

            setTranslateX(-32.5);
            setTranslateY(32.5);
        }
    }

    @Override
    abstract void setup(String id);

}
