package characters;

import level.Level;
import org.apache.commons.lang3.tuple.Pair;
import projectiles.EnemyProjectile;
import projectiles.PlayerProjectile;

public class Enemy extends Person{


    public Enemy(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    @Override
    public void shoot(Pair<Float,Float> direction) {
        if(level == null) {
            throw new IllegalStateException("enemy has no level");
        }
        level.projectiles.add(new EnemyProjectile(getxCenterCoordinate(),getyCenterCoordinate(),1,direction,1));
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
