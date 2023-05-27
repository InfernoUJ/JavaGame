package specificTiles;

import map.Trap;

public class Spikes extends Trap {
    public Spikes(int xCenterCoordinate, int yCenterCoordinate) {

        super(xCenterCoordinate,yCenterCoordinate);
        setDamage(1);
    }

}
