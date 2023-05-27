package projectiles;

import characters.Person;
import specificTiles.Wall;
import org.apache.commons.lang3.tuple.Pair;

public class BigAoeAttack extends Projectile{

    private int radius;

    BigAoeAttack(float xCenterCoordinates, float yCenterCoordinates, Pair<Float, Float> direction) {
        super(xCenterCoordinates, yCenterCoordinates, direction);
    }

    @Override
    void hit(Person a) {

    }

    @Override
    void hit(Wall a) {

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
