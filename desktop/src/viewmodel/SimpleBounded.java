package viewmodel;

import com.badlogic.gdx.math.Rectangle;
import coreStructures.Coordinates;

public class SimpleBounded implements Bounded{
    protected final Coordinates myEntity;
    protected Rectangle bound;
    public SimpleBounded(Coordinates myEntity, Rectangle bound) {
        this.myEntity = myEntity;
        this.bound = bound;
    }
    @Override
    public Rectangle getBound() {
        return bound;
    }
    protected void setBound(Rectangle bound) {
        this.bound = bound;
    }
    public void updateBound() {
        this.bound = new Rectangle(myEntity.getxCenterCoordinate(), myEntity.getyCenterCoordinate(), bound.width, bound.height);
    }
    public float getX(){
        return myEntity.getxCenterCoordinate();
    }
    public float getY(){
        return myEntity.getyCenterCoordinate();
    }
}
