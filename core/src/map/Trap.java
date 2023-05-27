package map;

import characters.Person;

public abstract class Trap extends Tile {
    private boolean activated = false;
    private int damage = 0;
    protected Trap(int xCenterCoordinate, int yCenterCoordinate) {
        super(xCenterCoordinate,yCenterCoordinate);
    }

    public boolean isActivated() {
        return activated;
    }

    public void activate() {
        this.activated = true;
    }
    public void deactivate() {
        this.activated = false;
    }

    public void setDamage(int damage) {
        if(damage < 0) {
            throw new IllegalArgumentException(("Trap cannot deal negative damage"));
        }
        this.damage = damage;
    }
    public void hit(Person a) {
        if(isActivated()) {
            throw new IllegalStateException("inactive trap cannot hit anybody");
        }
        if(a == null) {
            throw new NullPointerException("trap tries to hit a null");
        }
        a.getHit(damage);
    }

    public int getDamage() {

        return damage;

    }
}
