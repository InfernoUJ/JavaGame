package view;

import characters.Person;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import viewmodel.GameManager;

public class Character extends Actor implements Bounded {
    public final Person myhero;
    private Rectangle bound;
    public final HpBar hpBar;
    private final TextureRegion texture;
    private boolean killed = false;

    public Character(Person myhero, TextureRegion texture) {
        super();
        this.myhero = myhero;
        this.texture = texture;
        this.hpBar = new HpBar(100, 10, com.badlogic.gdx.graphics.Color.BLACK, com.badlogic.gdx.graphics.Color.GREEN);
        setBound();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(!killed) {
            batch.draw(texture, myhero.getxCenterCoordinate(), myhero.getyCenterCoordinate());
            hpBar.setCurrentValue((float) myhero.getHealthPoints() / (float) myhero.maxHealthPoints);

            hpBar.draw(batch, parentAlpha);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(myhero.getxCenterCoordinate());
        setY(myhero.getyCenterCoordinate());
        hpBar.setX(getX());
        hpBar.setY(getY() + texture.getTexture().getHeight() + 10); // Position the hpBar below the character
        hpBar.act(delta);
    }

    public void kill() {
        killed = true;
    }

    public Rectangle getBound() {
        return bound;
    }

    private void setBound() {
        bound = new Rectangle(myhero.getxCenterCoordinate(), myhero.getyCenterCoordinate(), texture.getRegionWidth(), texture.getRegionHeight());
    }
}
