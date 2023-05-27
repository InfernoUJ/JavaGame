package characters;

import projectiles.BigAoeAttack;
import projectiles.PlayerProjectile;

public class Player extends Person{

    private int bigAoeCooldown;
    public Player(int xCenterCoordinate, int yCenterCoordinate) {
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


    public void dectementBigAoeCdByOne() {

    }

    public BigAoeAttack shootBigAoeAttack() {

        return null;
    }
    @Override
    public PlayerProjectile shoot(float a, float b) {
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
