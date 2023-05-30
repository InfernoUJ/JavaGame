package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;

import specificTiles.Wall;

public class FullWallBlock extends BlockOfTiles {

    public FullWallBlock(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate,yCenterCoordinate);
        internalTiles.add(new Wall((int) (getxCenterCoordinate() - Tile.width), (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new Wall((int)getxCenterCoordinate(), (int)getyCenterCoordinate()));
        internalTiles.add(new Wall((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new Wall((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Wall((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() - Tile.length));
    }


}
