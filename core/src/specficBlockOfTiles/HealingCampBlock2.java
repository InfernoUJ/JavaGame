package specficBlockOfTiles;

import map.BlockOfTiles;
import map.Tile;
import specificTiles.*;

public class HealingCampBlock2 extends BlockOfTiles {

    public HealingCampBlock2(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate,yCenterCoordinate);
        internalTiles.add(new Spikes((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new SlowingTrap((int)getxCenterCoordinate() , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() + Tile.length));
        internalTiles.add(new SlowingTrap((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new HealingCamp((int)getxCenterCoordinate(), (int)getyCenterCoordinate()));
        internalTiles.add(new SlowingTrap((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate()));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() - Tile.width , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new SlowingTrap((int)getxCenterCoordinate() , (int)getyCenterCoordinate() - Tile.length));
        internalTiles.add(new Spikes((int)getxCenterCoordinate() + Tile.width , (int)getyCenterCoordinate() - Tile.length));
    }

}