package SpecificTiles;

import Map.Trap;

public class SlowingTrap extends Trap {
    private int slowPercent = 0;

    SlowingTrap(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    public void setSlowPercent(int slowPercent) {
        this.slowPercent = slowPercent;
    }

    public int getSlowPercent() {
        return slowPercent;
    }
}
