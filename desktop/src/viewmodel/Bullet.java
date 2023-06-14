package viewmodel;

import com.badlogic.gdx.math.Rectangle;
import projectiles.Projectile;

public class Bullet extends SimpleBounded{
    protected final Projectile myProjectile;
    Bullet(Projectile myProjectile, Rectangle bound){
        super(myProjectile, bound);
        this.myProjectile = myProjectile;
        setBound(bound);
    }
    public boolean isEnemyBullet(){
        return myProjectile instanceof projectiles.EnemyProjectile;
    }
}
