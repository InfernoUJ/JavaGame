package coreStructures;

import com.sun.tools.javac.util.Pair;

public  interface Movable  {
    void setSpeed(int speed);
    int getSpeed();
    void setDirection(Pair<Integer,Integer> direction);
    Pair<Integer,Integer> getDirection();
    default void stopMoving(){
        setSpeed(0);
    }

}
