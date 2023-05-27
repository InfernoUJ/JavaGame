package map;

public abstract class Trap extends Tile {
    private boolean activated;
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

    public int getDamage() {
        if(isActivated()){return damage;}
        return 0;
    }
}
