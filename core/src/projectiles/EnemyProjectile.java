package projectiles;

import characters.Person;
import specificTiles.Wall;
import org.apache.commons.lang3.tuple.Pair;

public class EnemyProjectile extends Projectile {


    EnemyProjectile(float xCenterCoordinates, float yCenterCoordinates,int speed ,Pair<Float,Float> direction) {
        super(xCenterCoordinates, yCenterCoordinates,speed, direction);

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
