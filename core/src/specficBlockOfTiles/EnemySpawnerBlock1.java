package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;
import specificTiles.NormalTile;

public class EnemySpawnerBlock1 extends BlockOfTiles {
    EnemySpawnerBlock1(int xCenterCoordinate, int yCenterCoordinate) {
        setxCenterCoordinate(xCenterCoordinate);
        setyCenterCoordinate(yCenterCoordinate);
        //internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width ))
    }
}
