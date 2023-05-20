package coreStructures;

public abstract class Coordinates {
    private float xCenterCoordinate;
    private float yCenterCoordinate;

    public abstract int getWidth();
    public abstract int getLength();

    public float getxCenterCoordinate() {
        return xCenterCoordinate;
    }

    public float getyCenterCoordinate() {
        return yCenterCoordinate;
    }

    public void setxCenterCoordinate(int xCenterCoordinate) {
        this.xCenterCoordinate = xCenterCoordinate;
    }

    public void setyCenterCoordinate(int yCenterCoordinate) {
        this.yCenterCoordinate = yCenterCoordinate;
    }
}
