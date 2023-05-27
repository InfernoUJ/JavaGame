package map;

import coreStructures.Coordinates;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockOfTiles extends Coordinates {


    private final static int width = 3* Tile.width;
    private final static int length = 3*Tile.length;
    public final List<Tile> internalTiles= new ArrayList<>(width/Tile.width);

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getLength() {
        return length;
    }
}
