package projectiles;

import characters.Person;
import specificTiles.Wall;
import org.apache.commons.lang3.tuple.Pair;

public class PlayerProjectile extends Projectile{
    PlayerProjectile(float xCenterCoordinates, float yCenterCoordinates, Pair<Float, Float> direction) {
        super(xCenterCoordinates, yCenterCoordinates, direction);
    }

    @Override
    void hit(Person a) {

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
