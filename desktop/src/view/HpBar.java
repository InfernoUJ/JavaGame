package view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class HpBar extends Actor {
    private float maxWidth;
    private float currentWidth;
    private float height;
    private Color backgroundColor;
    private Color foregroundColor;
    private TextureRegion foregroundTexture;

    public HpBar(float maxWidth, float height, Color backgroundColor, Color foregroundColor) {
        this.maxWidth = maxWidth;
        this.currentWidth = maxWidth;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        setWidth(maxWidth);
        setHeight(height);
        foregroundTexture = createForegroundTextureRegion();
    }

    public void setCurrentValue(float currentValue) {
        currentWidth = maxWidth * currentValue;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        System.out.println("HpBar draw" + currentWidth + " " + height);
        batch.draw(foregroundTexture, getX(), getY(), currentWidth, height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    private TextureRegion createForegroundTextureRegion() {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(foregroundColor);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegion(texture);
    }
}