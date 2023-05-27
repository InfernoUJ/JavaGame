package specificTiles;

import map.Tile;

public class HealingCamp extends Tile {
    private int healingPercent;
    public HealingCamp(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    public int getHealingPercent() {
        return healingPercent;
    }

    public void setHealingPercent(int healingPercent) {
        this.healingPercent = healingPercent;
    }
}
