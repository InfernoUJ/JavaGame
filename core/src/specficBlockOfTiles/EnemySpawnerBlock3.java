package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;
import specificTiles.*;

public class EnemySpawnerBlock3 extends BlockOfTiles {
    EnemySpawnerBlock3(int xCenterCoordinate, int yCenterCoordinate) {
        setxCenterCoordinate(xCenterCoordinate);
        setyCenterCoordinate(yCenterCoordinate);
        internalTiles.add(new HealingCamp((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new EnemySpawner((int)getxCenterCoordinate() , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new EnemySpawner((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new EnemySpawner((int)getxCenterCoordinate(), (int)getyCenterCoordinate()));
        internalTiles.add(new Wall((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new SlowingTrap((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() - Tile.length));
    }
}
