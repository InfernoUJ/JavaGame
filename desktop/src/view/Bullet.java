package view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import projectiles.Projectile;

public class Bullet extends Actor {
    private float radius;
    private TextureRegion bulletTexture;
    private final Projectile myProjectile;
    public Bullet(float radius, Projectile myProjectile) {
        this.myProjectile = myProjectile;
        this.radius = radius;
        setBounds(myProjectile.getxCenterCoordinate() - radius, myProjectile.getyCenterCoordinate() - radius, 2 * radius, 2 * radius);
        bulletTexture = createBulletTexture(radius);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //System.out.println("Drawing bullet "+myProjectile.getxCenterCoordinate()+" "+myProjectile.getyCenterCoordinate());
        super.draw(batch, parentAlpha);
        batch.draw(bulletTexture, myProjectile.getxCenterCoordinate(), myProjectile.getyCenterCoordinate());
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
}
