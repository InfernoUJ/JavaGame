package map;

import com.badlogic.gdx.Gdx;
import coreStructures.Coordinates;

public abstract class Tile extends Coordinates {
    //tile class - represents a single tile on the board.


    public static final int width = 2;
    public static final int length = 2;

    public Tile(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
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
