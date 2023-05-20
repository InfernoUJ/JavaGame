package Projectiles;

import Characters.Person;
import SpecificTiles.Wall;
import com.sun.tools.javac.util.Pair;

public class EnemyProjectile extends Projectile {


    EnemyProjectile(float xCenterCoordinates, float yCenterCoordinates, Pair<Float,Float> direction) {
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
