package map;

import com.badlogic.gdx.Gdx;
import coreStructures.Coordinates;

public abstract class Tile extends Coordinates {
    //tile class - represents a single tile on the board.

    /* @TODO
         -what if window size changes?
     */
    public static final int width = Gdx.graphics.getWidth()/39;
    public static final int length = Gdx.graphics.getHeight()/15;

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
