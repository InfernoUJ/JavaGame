package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import projectiles.Projectile;

public class Bullet extends Actor implements Bounded{
    private float radius;
    private Rectangle bound;
    private TextureRegion bulletTexture;
    private final Projectile myProjectile;
    private boolean wasHit = false;
    public Bullet(float radius, Projectile myProjectile) {
        this.myProjectile = myProjectile;
        this.radius = radius;
        setBounds(myProjectile.getxCenterCoordinate() - radius, myProjectile.getyCenterCoordinate() - radius, 2 * radius, 2 * radius);
        bulletTexture = createBulletTexture(radius);
    }
    public void hit(){
        wasHit = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //System.out.println("Drawing bullet "+myProjectile.getxCenterCoordinate()+" "+myProjectile.getyCenterCoordinate());
        super.draw(batch, parentAlpha);
        if(!wasHit){
            batch.draw(bulletTexture, myProjectile.getxCenterCoordinate(), myProjectile.getyCenterCoordinate());
        }
        if(wasHit){
//            batch.flush();
//            Gdx.gl.glClearColor(0, 0, 0, 0); // Transparent color
//            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
    }

    private TextureRegion createBulletTexture(float radius) {
        int diameter = (int) (2 * radius);
        Pixmap pixmap = new Pixmap(diameter, diameter, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fillCircle((int)radius, (int)radius, (int) radius);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegion(texture);
    }

    public void dispose() {
        bulletTexture.getTexture().dispose();
    }

    public boolean hasProjectile(Projectile p) {
        return p == myProjectile;
    }

    public Rectangle getBound() {
        return bound;
    }
    private void setBound() {
        bound = new Rectangle(myProjectile.getxCenterCoordinate(), myProjectile.getyCenterCoordinate(), bulletTexture.getRegionWidth(), bulletTexture.getRegionHeight());
    }
}
