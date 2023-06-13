package view;

import characters.Person;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import viewmodel.Character;

public class CharacterDrawable extends SimpleBoundedActor {
    protected final Character myHero;
    protected final HpBar hpBar;
    private boolean killed = false;

    public CharacterDrawable(Character myHero, TextureRegion texture) {
        super(myHero, texture);
        this.myHero = myHero;
        hpBar = new HpBar(myHero.getBound().width, 10, Color.RED, Color.GREEN);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        updateHpBar();
        hpBar.draw(batch, parentAlpha);
    }

    protected void updateHpBar() {
        hpBar.setX(myHero.getX());
        hpBar.setY(myHero.getY() + myHero.getBound().height);
        hpBar.setCurrentValue(myHero.getHpInPercent());
    }


//
//    public void kill() {
//        killed = true;
//    }
//
//    public Rectangle getBound() {
//        return bound;
//    }
//
//    private void setBound() {
//        bound = new Rectangle(myhero.getxCenterCoordinate(), myhero.getyCenterCoordinate(), texture.getRegionWidth(), texture.getRegionHeight());
//    }
}
