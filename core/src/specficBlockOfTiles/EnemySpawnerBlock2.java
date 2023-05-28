package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;
import specificTiles.EnemySpawner;
import specificTiles.NormalTile;
import specificTiles.Wall;

public class EnemySpawnerBlock2 extends BlockOfTiles {
    public EnemySpawnerBlock2(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate,yCenterCoordinate);
        internalTiles.add(new Wall((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new EnemySpawner((int)getxCenterCoordinate(), (int)getyCenterCoordinate()));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new Wall((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() - Tile.length));
    }
}