package map;

public abstract class Trap extends Tile {
    private boolean activated;
    private int damage;
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
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
