package coreStructures;

public abstract class Coordinates {
    private int xCenterCoordinate;
    private int yCenterCoordinate;

    public abstract int getWidth();
    public abstract int getLength();

    public int getxCenterCoordinate() {
        return xCenterCoordinate;
    }

    public int getyCenterCoordinate() {
        return yCenterCoordinate;
    }

    public void setxCenterCoordinate(int xCenterCoordinate) {
        this.xCenterCoordinate = xCenterCoordinate;
    }

    public void setyCenterCoordinate(int yCenterCoordinate) {
        this.yCenterCoordinate = yCenterCoordinate;
    }
}
