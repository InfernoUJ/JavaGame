package view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import viewmodel.GameManager;

public class Hero extends Actor {
    private final TextureRegion texture;
    public Hero(){
        super();
        texture = new TextureRegion(new Texture("hero.png"));
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY());
    }
}
