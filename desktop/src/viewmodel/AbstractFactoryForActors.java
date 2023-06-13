package viewmodel;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import coreStructures.Coordinates;
import org.apache.commons.lang3.tuple.Pair;
import view.SimpleBoundedActor;

public abstract class AbstractFactoryForActors <T extends SimpleBounded, S extends SimpleBoundedActor>{
    public abstract Pair<T, S> createPair(Coordinates entity, TextureRegion texture);
}
