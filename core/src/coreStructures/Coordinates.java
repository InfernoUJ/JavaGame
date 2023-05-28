package coreStructures;

public abstract class Coordinates {
    private float xCenterCoordinate;
    private float yCenterCoordinate;

    public  abstract int getWidth();
    public abstract int getLength();
    public Coordinates(float xCenterCoordinate, float yCenterCoordinate) {
        this.xCenterCoordinate = xCenterCoordinate;
        this.yCenterCoordinate = yCenterCoordinate;
    }

    public float getxCenterCoordinate() {
        return xCenterCoordinate;
    }

    public float getyCenterCoordinate() {
        return yCenterCoordinate;
    }

    public void setxCenterCoordinate(float xCenterCoordinate) {
        this.xCenterCoordinate = xCenterCoordinate;
    }

    public void setyCenterCoordinate(float yCenterCoordinate) {
        this.yCenterCoordinate = yCenterCoordinate;
    }
}
