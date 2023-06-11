package projectiles;

import characters.Person;
import characters.Player;
import org.apache.commons.lang3.tuple.Pair;

public class PlayerProjectile extends Projectile{
    public PlayerProjectile(float xCenterCoordinates, float yCenterCoordinates,int speed, Pair<Float, Float> direction, int damage) {
        super(xCenterCoordinates, yCenterCoordinates, speed,direction, damage);
    }

    @Override
    public void hit(Person a) {
        if(a instanceof Player) {
            return;
        }
        a.getHit(getDamage());
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
