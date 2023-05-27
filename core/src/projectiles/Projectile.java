package projectiles;

import characters.Person;
import specificTiles.Wall;
import org.apache.commons.lang3.tuple.Pair;
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

    public Projectile(float xCenterCoordinates, float yCenterCoordinates, int speed, Pair<Float,Float> direction) {
        setxCenterCoordinate(xCenterCoordinates);
        setyCenterCoordinate(yCenterCoordinates);
        setDirection(direction);
        setSpeed(speed);
    }
    abstract void hit(Person a);

    @Override
    public void setSpeed(int speed) {

    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void setDirection(Pair<Float, Float> direction) {
        destinationXCoordinate = direction.getLeft();
        destinationYCoordinate  =direction.getRight();
    }

    @Override
    public Pair<Float, Float> getDirection() {
       return Pair.of(destinationXCoordinate,destinationYCoordinate);
    }
}
