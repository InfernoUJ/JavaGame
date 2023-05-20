package Projectiles;

import com.sun.tools.javac.util.Pair;

public class PlayerProjectile extends Projectile{
    PlayerProjectile(float xCenterCoordinates, float yCenterCoordinates, Pair<Float, Float> direction) {
        super(xCenterCoordinates, yCenterCoordinates, direction);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
