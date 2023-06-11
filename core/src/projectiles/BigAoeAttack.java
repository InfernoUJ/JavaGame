package projectiles;

import characters.Person;
import org.apache.commons.lang3.tuple.Pair;



public class BigAoeAttack extends Projectile {

    private int radius;

    public BigAoeAttack(float xCenterCoordinates, float yCenterCoordinates, int radius, int damage) {
        super(xCenterCoordinates, yCenterCoordinates, 0,Pair.of((float)0,(float)0), damage);
        this.radius = radius;
    }

    @Override
    public void hit(Person a) {
        if(a == null) {
            throw new NullPointerException("projectile hit a null");
        }
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
