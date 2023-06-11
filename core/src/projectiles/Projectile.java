package projectiles;

import characters.Person;
import org.apache.commons.lang3.tuple.Pair;
import coreStructures.Coordinates;
import coreStructures.Movable;

public abstract class Projectile extends Coordinates implements Movable {
    private int damage;
    private int speed;
    private float destinationXCoordinate;
    private float destinationYCoordinate;
    private float xCenterCoordinate;
    private float yCenterCoordinate;


    public int getDamage() {
        return damage;
    }
    public float getxCenterCoordinate() {
        return xCenterCoordinate;
    }
    public float getyCenterCoordinate() {
        return yCenterCoordinate;
    }
    public void move(float delta){
        xCenterCoordinate += delta * speed * (destinationXCoordinate-xCenterCoordinate);
        yCenterCoordinate += delta * speed * (destinationYCoordinate-yCenterCoordinate);
    }

    public void setDamage(int damage) {
        if(damage < 0) {
            throw new IllegalArgumentException("Projectile:setDmg - cannot deal negative damage");
        }
        this.damage = damage;
    }

    public Projectile(float xCenterCoordinates, float yCenterCoordinates, int speed, Pair<Float,Float> direction, int damage) {
        super(xCenterCoordinates,yCenterCoordinates);
        if(speed < 0) {
            throw new IllegalArgumentException("Projectile - cannot give negative speed to a projectile");
        }
        setxCenterCoordinate(xCenterCoordinates);
        setyCenterCoordinate(yCenterCoordinates);
        setDirection(direction);
        setSpeed(speed);
        setDamage(damage);
    }
    abstract void hit(Person a);

    @Override
    public void setSpeed(int speed) {
        if(speed < 0) {
            throw  new IllegalArgumentException("setSpeed - cannot give negative speed to a projectile");
        }
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setDirection(Pair<Float, Float> direction) {
        destinationXCoordinate = direction.getLeft();
        destinationYCoordinate  = direction.getRight();
    }

    @Override
    public Pair<Float, Float> getDirection() {
       return Pair.of(destinationXCoordinate,destinationYCoordinate);
    }
}
