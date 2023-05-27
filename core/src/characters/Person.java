package characters;

import projectiles.Projectile;

import coreStructures.Coordinates;
import coreStructures.Movable;
import org.apache.commons.lang3.tuple.Pair;

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
    public void getHit(int damage) {

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
    public void setDirection(Pair<Float, Float> direction) {

    }

    @Override
    public Pair<Float, Float> getDirection() {
        return null;
    }
}
