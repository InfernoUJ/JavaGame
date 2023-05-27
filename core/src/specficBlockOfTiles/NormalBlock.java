package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;
import specificTiles.NormalTile;

public class NormalBlock extends BlockOfTiles {
    NormalBlock(int xCenterCoordinate, int yCenterCoordinate){
        setxCenterCoordinate(xCenterCoordinate);
        setyCenterCoordinate(yCenterCoordinate);
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate(), (int)getyCenterCoordinate()));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new NormalTile((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() - Tile.length));
    }
}
