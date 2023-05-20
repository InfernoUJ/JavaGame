package Characters;

import Projectiles.EnemyProjectile;
import Projectiles.Projectile;

public class Enemy extends Person{

    public Enemy(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    @Override
    public EnemyProjectile shoot(float a, float b) {
        return null;
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
