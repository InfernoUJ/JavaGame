package Projectiles;

import com.sun.tools.javac.util.Pair;

public class BigAoeAttack extends Projectile{

    private int radius;

    BigAoeAttack(float xCenterCoordinates, float yCenterCoordinates, Pair<Float, Float> direction) {
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
