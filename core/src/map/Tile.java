package map;

import com.badlogic.gdx.Gdx;
import coreStructures.Coordinates;

public abstract class Tile extends Coordinates {
    //tile class - represents a single tile on the board.


    public static final int width = 1;
    public static final int length = 1;

    public Tile(int xCenterCoordinate, int yCenterCoordinate) {
        setxCenterCoordinate(xCenterCoordinate);
        setyCenterCoordinate(yCenterCoordinate);
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
