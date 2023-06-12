package characters;

import org.apache.commons.lang3.tuple.Pair;
import projectiles.BigAoeAttack;
import projectiles.PlayerProjectile;
import projectiles.Projectile;

public class Player extends Person{

    private float bigAoeCooldown;
    public final float basicBigAoeCooldown = 20;

    public Player(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
        speed = 5;
    }

    @Override
    public float getShootingCooldown() {
        return super.getShootingCooldown();
    }

    public float getBigAoeCooldown() {
        return bigAoeCooldown;
    }

    public void setBigAoeCooldown(float bigAoeCooldown) {
        this.bigAoeCooldown = bigAoeCooldown;
    }


    public void decrementBigAoeCd(float delta) {
        bigAoeCooldown-=delta;
    }
    public void resetBigAoeCd() {
        bigAoeCooldown = basicBigAoeCooldown;
    }

    public void shootBigAoeAttack(float xCoordinate, float yCoordinate, int radius) {
        if(level == null) {
            throw new IllegalStateException("player has no level");
        }
        if(bigAoeCooldown> 0) {
            return;
        }
        level.projectiles.add(new BigAoeAttack(xCoordinate,yCoordinate,radius,1));
    }
    @Override
    public Projectile shoot(Pair<Float,Float> direction) {
        if(level == null) {
            throw new IllegalStateException("player has no level");
        }
        if(getShootingCooldown()>0) {
            return null;
        }
        Projectile p = new PlayerProjectile(getxCenterCoordinate(),getyCenterCoordinate(),1,direction,10);
        level.projectiles.add(p);
        return p;
    }


}

