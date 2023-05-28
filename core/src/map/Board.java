package map;

import coreStructures.Coordinates;
import suppliers.BlockOfTilesSupplier;

import java.util.ArrayList;
import java.util.List;

public class Board extends Coordinates {
    // Board is main game background
    // It is made of blocks of tiles
    // Size of Board is 15 x 39 Tiles
    // or 5 x 13 Blocks

    // Imagine its is matrix with dimensions 5 x 13
    public List<BlockOfTiles> blocks = new ArrayList<>(5*13);

    public Board(BlockOfTilesSupplier blockOfTilesSupplier){
        setxCenterCoordinate(0);
        setyCenterCoordinate(0);
    }
    @Override
    public int getWidth() {
        return 41 * Tile.width;
    }

    @Override
    public int getLength() {
        return 17*Tile.length;
    }

    public void placeBlock(BlockOfTiles blockOfTiles, int rowNumber, int columNumber){
        blocks.add(rowNumber*5 + columNumber, blockOfTiles);
    }
    public void activateAllTraps() {

    }
    public void deactivateAllTraps() {

    }
}



