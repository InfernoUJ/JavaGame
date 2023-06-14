package view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import viewmodel.SimpleBounded;

public class BulletDrawable extends SimpleBoundedActor{
    public BulletDrawable(SimpleBounded myEntity, TextureRegion texture) {
        super(myEntity, texture);
    }
}
