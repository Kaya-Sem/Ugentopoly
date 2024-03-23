package be.ugent.objprog.ugentopoly.Tiles;

public class SmallTile extends Tile {

    protected int rotatie;

    public SmallTile(int rotatie){
        this.rotatie = rotatie;
        setRotate(rotatie);
        setMinHeight(Tile.SHORT_SIDE);
        setMaxHeight(Tile.SHORT_SIDE);
        setMinWidth(Tile.LONG_SIDE);
        setMaxWidth(Tile.LONG_SIDE);
}
}
