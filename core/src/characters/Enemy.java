package characters;

import level.Level;
import org.apache.commons.lang3.tuple.Pair;
import projectiles.EnemyProjectile;
import projectiles.Projectile;


public class Enemy extends Person{



    public Enemy(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }


    @Override
    public Projectile shoot(Pair<Float,Float> direction) {
        if(level == null) {
            throw new IllegalStateException("enemy has no level");
        }
        if(getShootingCooldown()>0) {
            return null;
        }
        Projectile p = new EnemyProjectile(getxCenterCoordinate(),getyCenterCoordinate(),1,direction,5);
        level.projectiles.add(p);
        return p;
    }



}
