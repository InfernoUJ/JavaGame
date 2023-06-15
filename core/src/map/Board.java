package map;

import coreStructures.Coordinates;
import specficBlockOfTiles.FullWallBlock;
import specficBlockOfTiles.PlayerSpawnerBlock;
import suppliers.BlockOfTilesSupplier;

import java.util.ArrayList;
import java.util.List;

public class Board extends Coordinates {
    // Board is main game background
    // It is made of blocks of tiles
    // Size of Board is 15 x 39 Tiles
    // or 5 x 13 Blocks

    // Imagine its is matrix with dimensions 5 x 13 with artificial walls around it
    public List<BlockOfTiles> blocks = new ArrayList<>(7*15);

    public Board(BlockOfTilesSupplier blockOfTilesSupplier){
        super(0,0);
        for(int i = 0; i < 15;i++) {
            blocks.add(new FullWallBlock(-7*BlockOfTiles.width + i*BlockOfTiles.width,3) );
        }
        for(int y = 0; y < 2;y++) {
            blocks.add(new FullWallBlock(-7*BlockOfTiles.width, 2 * BlockOfTiles.length - y*BlockOfTiles.length));
            for (int x = 0; x < 13; x++) {
               blocks.add(blockOfTilesSupplier.generateBlock(-6 * BlockOfTiles.width + x*BlockOfTiles.width, 2 * BlockOfTiles.length - y*BlockOfTiles.length));
            }
            blocks.add(new FullWallBlock(7*BlockOfTiles.width,2 * BlockOfTiles.length - y*BlockOfTiles.length));
        }
        blocks.add(new FullWallBlock(-7*BlockOfTiles.width,0));
        for(int x = 0; x < 6;x++) {
            blocks.add(blockOfTilesSupplier.generateBlock((-6 + x)* BlockOfTiles.width,0));
        }
        blocks.add(new PlayerSpawnerBlock(0,0));
        for(int x = 7;x < 13;x++) {
            blocks.add(blockOfTilesSupplier.generateBlock((-6 + x)* BlockOfTiles.width,0));
        }
        blocks.add(new FullWallBlock(7*BlockOfTiles.width,0));
        for(int y = 3; y< 5;y++) {
            blocks.add(new FullWallBlock(-7*BlockOfTiles.width, 2 * BlockOfTiles.length - y*BlockOfTiles.length));
            for (int x = 0; x < 13; x++) {
                blocks.add(blockOfTilesSupplier.generateBlock(-6 * BlockOfTiles.width + x*BlockOfTiles.width, 2 * BlockOfTiles.length - y*BlockOfTiles.length));
            }
            blocks.add(new FullWallBlock(7*BlockOfTiles.width,2 * BlockOfTiles.length - y*BlockOfTiles.length));
        }
    }
    @Override
    public int getWidth() {
        return 15 * BlockOfTiles.width;
    }

    @Override
    public int getLength() {
        return 7 * BlockOfTiles.length;
    }

    public void activateAllTraps() {
        for(BlockOfTiles blockOfTiles:blocks) {
            for(Tile tile:blockOfTiles.internalTiles) {
                if(tile.getClass().isAssignableFrom(Trap.class)) {
                    ((Trap)tile).activate();
                }
            }
        }
    }
    public void deactivateAllTraps() {
        for(BlockOfTiles blockOfTiles:blocks) {
            for(Tile tile:blockOfTiles.internalTiles) {
                if(tile.getClass().isAssignableFrom(Trap.class)) {
                    ((Trap)tile).deactivate();
                }
            }
        }
    }

    // center coordinates in left down corner
    public List<List<Tile>> getTiles() {
        int y = 20;
        int x = 0;
        List<List<Tile>> tiles = new ArrayList<>();
        for(int i = 0; i < 21;i++) {
            tiles.add(new ArrayList<>(45));
        }
        int j = 0;
        for(BlockOfTiles block: blocks){
            int i = 0;
            for(Tile tile : block.internalTiles){
                tiles.get(y-i/3).add(x+i%3, tile);
                i++;
            }
            j++;
            x+=3;
            if(j%13 == 0) {
                y-=3;
                x=0;
            }
        }

        return tiles;
    }
}



