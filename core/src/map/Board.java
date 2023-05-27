package map;

import coreStructures.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Board extends Coordinates {

    public List<BlockOfTiles> blocks = new ArrayList<>();
    @Override
    public int getWidth() {
        return 41;
    }

    @Override
    public int getLength() {
        return 17;
    }

    public void placeBlock(BlockOfTiles blockOfTiles){

    }
    public void activateAllTraps() {

    }
    public void deactivateAllTraps() {

    }
}



