package characters;

import level.Level;
import projectiles.Projectile;

import coreStructures.Coordinates;
import coreStructures.Movable;
import org.apache.commons.lang3.tuple.Pair;

public  abstract class Person extends Coordinates implements Movable {
    int speed = 0;
    private Pair<Float,Float> direction = Pair.of(0f,0f);
    public Level level;
    private float shootingCooldown = 1;
    public final float basicShootingCooldown = 1;
    int healthPoints = 100;

    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getLength() {
        return 1;
    }

    public Person(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate,yCenterCoordinate);
    }
    public void setShootingCooldown(float cd) {
        shootingCooldown = cd;
    }

    public float getShootingCooldown() {
        return shootingCooldown;
    }
    public void decrementCd(float delta) {
        shootingCooldown-=delta;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void getHit(int damage) {
        healthPoints-=damage;
        if(healthPoints < 0) {
            stopMoving();
        }
    }
    public abstract void shoot(Pair<Float,Float> direction);
    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setDirection(Pair<Float, Float> direction) {
        this.direction = direction;
    }

    @Override
    public Pair<Float, Float> getDirection() {
        return direction;
    }
}
