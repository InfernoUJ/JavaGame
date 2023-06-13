package view;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import viewmodel.SimpleBounded;

public class SimpleBoundedActor extends Actor {
    protected final SimpleBounded myEntity;
    protected final TextureRegion texture;

    SimpleBoundedActor(SimpleBounded myEntity, TextureRegion texture) {
        this.myEntity = myEntity;
        this.texture = texture;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //System.out.println("Drawing bullet "+myProjectile.getxCenterCoordinate()+" "+myProjectile.getyCenterCoordinate());
        super.draw(batch, parentAlpha);
//        if(!wasHit){
        batch.draw(texture, myEntity.getX(), myEntity.getY());
//        }
//        if(wasHit){
////            batch.flush();
////            Gdx.gl.glClearColor(0, 0, 0, 0); // Transparent color
////            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        }
    }
}
