package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import projectiles.Projectile;
import viewmodel.GameManager;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenAdapter {
    private GameManager gameManager;
    private Stage currentStage;
    private Character character;
    private Map map;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer mapRenderer;
    private Character hero;
    private List<Character> enemies = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();
    public GameScreen(GameManager gameManager) {
        super();
        this.gameManager = gameManager;
        loadScene();
    }


    private void loadScene(){
        currentStage = new Stage(gameManager.getViewport());

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        // Set the camera's initial position and other properties as needed
        camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f, 0);
        camera.update();

        TiledMap map = new TmxMapLoader().load("simple_map.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);

        currentStage.addActor(new Actor(){
            @Override
            public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float parentAlpha) {
                mapRenderer.setView(camera);
                mapRenderer.render();
            }
        });

        hero = new Character(gameManager, gameManager.getPlayer(), new TextureRegion(new Texture("hero2.png")));
        currentStage.addActor(hero);

        loadEnemies();

    }
    public void addBullet(Projectile p){
        //System.out.println("Bullet added");
        Bullet b = new Bullet(7, p);
        bullets.add(b);
        currentStage.addActor(b);
    }
    private void loadEnemies(){
        enemies = gameManager.loadEnemies();
        for (Character enemy : enemies) {
            currentStage.addActor(enemy);
        }
    }
    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor((float)74/256,  (float)55/256, (float)40/256, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Set the background color
        // TODO: move it to textures and skin pack( or smth like that)

        //System.out.println("GameScreen render");


        currentStage.act(delta);
        currentStage.draw();
        gameManager.makeShooting(delta);
    }

    @Override
    public void resize(int width, int height) {
        currentStage.getViewport().update(width, height, true);
    }

    public void removeBullet(Projectile p) {
        int idx = -1;
        for(int i = 0; i < bullets.size(); i++){
            if(bullets.get(i).hasProjectile(p)){
                idx = i;
                break;
            }
        }
        if(idx > 0){
            bullets.get(idx).hit();
            bullets.get(idx).draw(currentStage.getBatch(), 0);
            bullets.get(idx).remove();
            bullets.remove(idx);
        }
    }
}
