package coreStructures;

import org.apache.commons.lang3.tuple.Pair;

public  interface Movable  {
    void setSpeed(int speed);
    int getSpeed();
    void setDirection(Pair<Float,Float> direction);
    Pair<Float,Float> getDirection();
    default void stopMoving(){
        setSpeed(0);
    }

}
