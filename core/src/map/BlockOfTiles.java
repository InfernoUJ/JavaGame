package map;

import coreStructures.Coordinates;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockOfTiles extends Coordinates {


    public final static int width = 3* Tile.width;
    public final static int length = 3*Tile.length;
    public final List<Tile> internalTiles= new ArrayList<>();

    public BlockOfTiles(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getLength() {
        return length;
    }
}
