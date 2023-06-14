package viewmodel;

import characters.Person;
import com.badlogic.gdx.math.Rectangle;

public class Character extends SimpleBounded {
    /*
    this class is entity, that connects model and view parts
    of player and enemies and bullets
    */
    protected final Person myPerson;
    Character(Person myEntity, Rectangle bound){
        super(myEntity, bound);
        this.myPerson = myEntity;
        setBound(bound);
    }
    public float getHpInPercent(){
        return (float) myPerson.getHealthPoints() / (float) myPerson.getMaxHealthPoints();
    }
}
