package specificTiles;

import map.Trap;

public class SlowingTrap extends Trap {
    private int slowPercent = 0;

    public SlowingTrap(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    public void setSlowPercent(int slowPercent) {
        this.slowPercent = slowPercent;
    }

    public int getSlowPercent() {
        return slowPercent;
    }
}
