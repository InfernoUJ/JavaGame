package viewmodel;

import com.badlogic.gdx.math.Rectangle;

public interface Bounded {
    Rectangle getBound();
    default boolean overlaps(Bounded other){
        return getBound().overlaps(other.getBound());
    }
    static boolean overlaps(Bounded a, Bounded b){
        return a.overlaps(b);
    }
    default boolean overlaps(float x, float y){
        return getBound().contains(x, y);
    }
}
