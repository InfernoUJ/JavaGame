package SpecficBlockOfTiles;

import Map.BlockOfTiles;
import Map.Tile;
import SpecificTiles.NormalTile;

public class EnemySpawnerBlock1 extends BlockOfTiles {
    EnemySpawnerBlock1(int xCenterCoordinate, int yCenterCoordinate) {
        setxCenterCoordinate(xCenterCoordinate);
        setyCenterCoordinate(yCenterCoordinate);
       // NormalTile a = new NormalTile(xCenterCoordinate - Tile.width, yCenterCoordinate + Tile.length);
        //internalTiles.add(a);
    }
}
