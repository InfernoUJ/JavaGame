package suppliers;


import map.BlockOfTiles;
import specficBlockOfTiles.*;
import specificTiles.Spikes;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BlockOfTilesSupplier {


    private int trapChance;
    private int wallChance;
    private int healingCampChance;
    private int enemyChance;


    public BlockOfTilesSupplier() {
        trapChance = 0;
        wallChance = 0;
        healingCampChance = 0;
        enemyChance = 0;
    }

    public BlockOfTiles generateBlock(float xCenterCoordinate, float yCenterCoordinate) {
        // add randomization in future
        if(trapChance + wallChance + healingCampChance + enemyChance > 100) {
            throw new IllegalStateException("chanses surpass 100%");
        }
        if(trapChance + wallChance + healingCampChance + enemyChance < 0) {
            throw new IllegalStateException("chanses below 0");
        }
        Random r = new SecureRandom();
        int generatedNumber =r.nextInt(1,100);
        if(generatedNumber <= enemyChance) {//TODO ugly af, optimize this
            int randomEnemyBlock = r.nextInt(1,4);
            if(randomEnemyBlock == 1) {
                return new EnemySpawnerBlock1(xCenterCoordinate, yCenterCoordinate);
            }
            if(randomEnemyBlock == 2) {
                return new EnemySpawnerBlock2(xCenterCoordinate, yCenterCoordinate);
            }
            if(randomEnemyBlock == 3) {
                return new EnemySpawnerBlock3(xCenterCoordinate, yCenterCoordinate);
            }
            return new EnemySpawnerBlock4(xCenterCoordinate, yCenterCoordinate);
        }
        if(generatedNumber <= enemyChance + wallChance) {
            if(generatedNumber%2==0) {
                return new WallBlock1(xCenterCoordinate, yCenterCoordinate);
            }
            return new WallBlock2(xCenterCoordinate, yCenterCoordinate);
        }
        if(generatedNumber <= enemyChance + wallChance + trapChance) {
            return new TrappedBlock(xCenterCoordinate, yCenterCoordinate);
        }
        if(generatedNumber <= enemyChance + wallChance + trapChance + healingCampChance) {
            if(generatedNumber%2 == 0) {
                return new HealingCampBlock1(xCenterCoordinate, yCenterCoordinate);
            }
            return new HealingCampBlock2(xCenterCoordinate, yCenterCoordinate);
        }
        return new NormalBlock(xCenterCoordinate, yCenterCoordinate);
    }

    public void setEnemyChance(int enemyChance) {
        if(enemyChance < 0) {
            throw new IllegalArgumentException("chance cannot be below 0");
        }
        this.enemyChance = enemyChance;
    }

    public void setHealingCampChance(int healingCampChance) {
        if(healingCampChance < 0) {
            throw new IllegalArgumentException("chance cannot be below 0");
        }
        this.healingCampChance = healingCampChance;
    }

    public int getEnemyChance() {
        return enemyChance;
    }

    public int getHealingCampChance() {
        return healingCampChance;
    }

    public int getTrapChance() {
        return trapChance;
    }

    public void setTrapChance(int trapChance) {
        if(trapChance< 0) {
            throw new IllegalArgumentException("chance cannot be below 0");
        }
        this.trapChance = trapChance;
    }

    public void setWallChance(int wallChance) {
        if(wallChance < 0) {
            throw new IllegalArgumentException("chance cannot be below 0");
        }
        this.wallChance = wallChance;
    }

    public int getWallChance() {
        return wallChance;
    }

}

