package view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import viewmodel.GameManager;

public class Character extends Actor {
    private final TextureRegion texture;
    private final GameManager gameManager;
    public Character(GameManager gameManager){
        super();
        texture = new TextureRegion(new Texture("hero2.png"));
        this.gameManager = gameManager;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, gameManager.getHeroXCoordinate(), gameManager.getHeroYCoordinate());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(gameManager.getHeroXCoordinate());
        setY(gameManager.getHeroYCoordinate());
    }
}
