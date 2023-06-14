package viewmodel;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import coreStructures.Coordinates;
import org.apache.commons.lang3.tuple.Pair;
import view.SimpleBoundedActor;

public class SupplierForBullets {

    protected SimpleBoundedActor createActor(SimpleBounded presenter, TextureRegion texture) {
        return new SimpleBoundedActor(presenter, texture);
    }

    protected SimpleBounded createVMPresenter(Coordinates entity, TextureRegion texture) {
        return new SimpleBounded(entity, new Rectangle(entity.getxCenterCoordinate(), entity.getyCenterCoordinate(), texture.getRegionWidth(), texture.getRegionHeight()));
    }

    public Pair<SimpleBounded, SimpleBoundedActor> createPair(Coordinates entity, TextureRegion texture){
        SimpleBounded presenter = createVMPresenter(entity, texture);
        SimpleBoundedActor actor = createActor(presenter, texture);
        return Pair.of(presenter, actor);
    }
}
