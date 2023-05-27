package map;

import coreStructures.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Board extends Coordinates {

    public List<BlockOfTiles> blocks = new ArrayList<>();
    @Override
    public int getWidth() {
        return 39;
    }

    @Override
    public int getLength() {
        return 15;
    }

    public void placeBlock(BlockOfTiles blockOfTiles){

    }
}



