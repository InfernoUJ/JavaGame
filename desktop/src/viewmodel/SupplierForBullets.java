package viewmodel;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import coreStructures.Coordinates;
import org.apache.commons.lang3.tuple.Pair;
import projectiles.Projectile;
import view.BulletDrawable;
import view.SimpleBoundedActor;

public class SupplierForBullets {

    protected BulletDrawable createActor(Bullet presenter, TextureRegion texture) {
        return new BulletDrawable(presenter, texture);
    }

    protected Bullet createVMPresenter(Projectile entity, TextureRegion texture) {
        return new Bullet(entity, new Rectangle(entity.getxCenterCoordinate(), entity.getyCenterCoordinate(), texture.getRegionWidth(), texture.getRegionHeight()));
    }

    public Pair<Bullet, BulletDrawable> createPair(Projectile entity, TextureRegion texture){
        Bullet presenter = createVMPresenter(entity, texture);
        BulletDrawable actor = createActor(presenter, texture);
        return Pair.of(presenter, actor);
    }
}
