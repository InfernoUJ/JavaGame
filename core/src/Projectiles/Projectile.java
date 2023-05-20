package Projectiles;

import com.sun.tools.javac.util.Pair;
import coreStructures.Coordinates;
import coreStructures.Movable;

public abstract class Projectile extends Coordinates implements Movable {
    private int damage;
    private int speed;
    private float destinationXCoordinate;
    private float destinationYCoordinate;


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    Projectile(float xCenterCoordinates, float yCenterCoordinates, Pair<Float,Float> direction) {

    }


    @Override
    public void setSpeed(int speed) {

    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void setDirection(Pair<Integer, Integer> direction) {

    }

    @Override
    public Pair<Integer, Integer> getDirection() {
        return null;
    }
}
