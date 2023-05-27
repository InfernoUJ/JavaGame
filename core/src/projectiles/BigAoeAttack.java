package projectiles;

import characters.Person;
import specificTiles.Wall;
import org.apache.commons.lang3.tuple.Pair;



public class BigAoeAttack extends Projectile {

    private int radius;

    public BigAoeAttack(float xCenterCoordinates, float yCenterCoordinates, int radius) {
        super(xCenterCoordinates, yCenterCoordinates, 0,Pair.of((float)0,(float)0));
        this.radius = radius;
    }

    @Override
    void hit(Person a) {
        a.getHit(this.getDamage());
    }



    @Override
    public int getWidth() {
        return 2*radius;
    }

    @Override
    public int getLength() {
        return 2*radius;
    }
}
