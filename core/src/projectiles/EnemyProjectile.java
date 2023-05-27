package projectiles;

import characters.Person;
import specificTiles.Wall;
import org.apache.commons.lang3.tuple.Pair;

public class EnemyProjectile extends Projectile {


    EnemyProjectile(float xCenterCoordinates, float yCenterCoordinates,int speed ,Pair<Float,Float> direction, int damage) {
        super(xCenterCoordinates, yCenterCoordinates,speed, direction, damage);

    }

    @Override
    void hit(Person a) {

    }



    @Override
    public int getWidth() {
        return 1;
    }

    @Override
    public int getLength() {
        return 1;
    }
}
