package Characters;

import Projectiles.Projectile;
import com.sun.tools.javac.util.Pair;
import coreStructures.Coordinates;
import coreStructures.Movable;

public  abstract class Person extends Coordinates implements Movable {
    int speed;
    Pair<Integer,Integer> direction;
    private int shootingCooldown;
    int healthPoints;
    public Person(int xCenterCoordinate, int yCenterCoordinate) {
        this.setxCenterCoordinate(xCenterCoordinate);
        this.setyCenterCoordinate(yCenterCoordinate);
    }
    public void setShootingCooldown(int cd) {

    }

    public int getShootingCooldown() {
        return shootingCooldown;
    }
    public void decrementCdByOne() {

    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void getDamage(int damage) {

    }
    public abstract Projectile shoot(float a,float b);
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
