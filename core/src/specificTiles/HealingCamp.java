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
        if(healingPercent < 0) {
            throw new IllegalArgumentException();
        }
        this.healingPercent = healingPercent;
    }
}
