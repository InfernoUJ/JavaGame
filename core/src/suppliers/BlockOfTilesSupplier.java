package suppliers;


import map.BlockOfTiles;


public class BlockOfTilesSupplier {


    private int trapChance;
    private int wallChance;
    private int healingCampChance;
    private int enemyChance;


    BlockOfTilesSupplier() {

    }

    BlockOfTiles generateBlock(int xCenterCoordinate, int yCenterCoordinate) {
        return null;
    }

    public void setEnemyChance(int enemyChance) {
        this.enemyChance = enemyChance;
    }

    public void setHealingCampChance(int healingCampChance) {
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
        this.trapChance = trapChance;
    }

    public void setWallChance(int wallChance) {
        this.wallChance = wallChance;
    }

    public int getWallChance() {
        return wallChance;
    }

}

