package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;
import specificTiles.NormalTile;
import specificTiles.Spikes;

public class TrappedBlock extends BlockOfTiles {
    public TrappedBlock(float xCenterCoordinate, float yCenterCoordinate){
        super(xCenterCoordinate,yCenterCoordinate);
        internalTiles.add(new Spikes((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new Spikes((int)getxCenterCoordinate(), (int)getyCenterCoordinate()));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() - Tile.length));
    }
}
