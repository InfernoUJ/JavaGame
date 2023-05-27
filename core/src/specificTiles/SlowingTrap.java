package specificTiles;

import characters.Person;
import map.Trap;

public class SlowingTrap extends Trap {
    private int slowPercent = 0;

    public SlowingTrap(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    public void setSlowPercent(int slowPercent) {
        if(slowPercent < 0 || slowPercent > 100) {
            throw new IllegalArgumentException("percent out of 0 - 100 range");
        }
        this.slowPercent = slowPercent;
    }

    public int getSlowPercent() {
        return slowPercent;
    }

    @Override
    public void hit(Person a) {
        if(!isActivated()) {
            throw new IllegalStateException("inactive trap cannot hit anybody");
        }
        if(a == null) {
            throw new NullPointerException("trap tries to hit a null");
        }
        a.setSpeed(a.getSpeed()*(slowPercent/100));
    }
}
