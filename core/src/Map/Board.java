package Map;

import coreStructures.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Board extends Coordinates {

    public List<?extends BlockOfTiles> blocks = new ArrayList<>();
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getLength() {
        return 0;
    }

    public void placeBlock(BlockOfTiles blockOfTiles){

    }
}



