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
    private void loadEnemies(){
        enemies = gameManager.loadEnemies();
        for (Character enemy : enemies) {
            currentStage.addActor(enemy);
        }
    }
    @Override
    public void render(float delta) {
        super.render(delta);
        // Set the background color
        // TODO: move it to textures and skin pack( or smth like that)
        Gdx.gl.glClearColor(0,  1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //System.out.println("GameScreen render");

        currentStage.act(delta);
        currentStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        currentStage.getViewport().update(width, height, true);
    }

}
