package view;

import characters.Person;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import viewmodel.GameManager;

public class Character extends Actor {
    private final Person myhero;
    public final HpBar hpBar;
    private final TextureRegion texture;
    private final GameManager gameManager;

    public Character(GameManager gameManager, Person myhero, TextureRegion texture) {
        super();
        this.gameManager = gameManager;
        this.myhero = myhero;
        this.texture = texture;
        this.hpBar = new HpBar(100, 10, com.badlogic.gdx.graphics.Color.BLACK, com.badlogic.gdx.graphics.Color.GREEN);
        hpBar.setX(getX());
        hpBar.setY(getY() + texture.getTexture().getHeight() +100);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, myhero.getxCenterCoordinate(), myhero.getyCenterCoordinate());
        //hpBar.setCurrentValue((float)myhero.getHealthPoints() / (float)gameManager.maxHealthPoints);
        hpBar.setX(getX());
        hpBar.setY(getY() + texture.getTexture().getHeight() +100);
        hpBar.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(gameManager.getHeroXCoordinate());
        setY(gameManager.getHeroYCoordinate());
        hpBar.setX(getX());
        hpBar.setY(getY() + texture.getTexture().getHeight() +100); // Position the hpBar below the character
        hpBar.act(delta);
    }
}
