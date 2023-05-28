package characters;

import org.apache.commons.lang3.tuple.Pair;
import projectiles.BigAoeAttack;
import projectiles.PlayerProjectile;

public class Player extends Person{

    private int bigAoeCooldown;

    public Player(float xCenterCoordinate, float yCenterCoordinate) {
        super(xCenterCoordinate, yCenterCoordinate);
    }

    @Override
    public int getShootingCooldown() {
        return super.getShootingCooldown();
    }

    public int getBigAoeCooldown() {
        return bigAoeCooldown;
    }

    public void setBigAoeCooldown(int bigAoeCooldown) {
        this.bigAoeCooldown = bigAoeCooldown;
    }


    public void decrementBigAoeCdByOne() {

    }

    public void shootBigAoeAttack(float xCoordinate, float yCoordinate, int radius) {
        if(level == null) {
            throw new IllegalStateException("player has no level");
        }
        level.projectiles.add(new BigAoeAttack(xCoordinate,yCoordinate,radius,1));
    }
    @Override
    public void shoot(Pair<Float,Float> direction) {
        if(level == null) {
            throw new IllegalStateException("player has no level");
        }
        level.projectiles.add(new PlayerProjectile(getxCenterCoordinate(),getyCenterCoordinate(),1,direction,1));
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
