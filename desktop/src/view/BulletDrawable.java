package view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import viewmodel.Bullet;
import viewmodel.SimpleBounded;
import viewmodel.SupplierForCharacters;

public class BulletDrawable extends SimpleBoundedActor{
    protected final Bullet myBullet;
    public BulletDrawable(Bullet myEntity, TextureRegion texture) {
        super(myEntity, texture);
        this.myBullet = myEntity;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        System.out.println("Drawing bullet "+getX()+" "+myBullet.getY()+" "+myBullet.getX()+" "+myBullet.getY());

    }
}
