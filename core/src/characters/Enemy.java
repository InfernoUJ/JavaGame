package characters;

import level.Level;
import org.apache.commons.lang3.tuple.Pair;
import projectiles.EnemyProjectile;


public class Enemy extends Person{


    public Enemy(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    @Override
    public void shoot(Pair<Float,Float> direction) {
        if(level == null) {
            throw new IllegalStateException("enemy has no level");
        }
        if(getShootingCooldown()>0) {
            return;
        }
        level.projectiles.add(new EnemyProjectile(getxCenterCoordinate(),getyCenterCoordinate(),1,direction,1));
    }



}
