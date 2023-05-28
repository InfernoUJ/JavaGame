package characters;

import level.Level;
import org.apache.commons.lang3.tuple.Pair;
import projectiles.EnemyProjectile;

public class Enemy extends Person{


    public Enemy(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    @Override
    public void shoot(Pair<Float,Float> direction) {

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
