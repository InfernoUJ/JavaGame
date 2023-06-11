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
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, myhero.getxCenterCoordinate(), myhero.getyCenterCoordinate());
        hpBar.setCurrentValue((float)myhero.getHealthPoints() / (float)gameManager.maxHealthPoints);

//            if(myhero instanceof characters.Enemy){
//                System.out.print("Enemy hp: ");
//            }
//            else {
//                System.out.print("Hero hp: ");
//            }
//            System.out.println(hpBar.getX()+" "+hpBar.getY());
//            System.out.println(myhero.getHealthPoints());

        hpBar.draw(batch, parentAlpha);
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
}
