package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import viewmodel.GameManager;
import viewmodel.Manager;

public class GameScreen extends ScreenAdapter implements InputProcessor{
    private GameManager gameManager;
    private Stage currentStage;
    private Hero hero;
    private Map map;
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer mapRenderer;
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
//        hero = new Hero(gameManager);
//        hero.addListener(new InputListener(){
//            @Override
//            public boolean keyDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, int keycode) {
//                hero.gameManager.processKeyDown(keycode);
//                return true;
//            }
//        });
    }
    @Override
    public void render(float delta) {
        super.render(delta);
        // Set the background color
        // TODO: move it to textures and skin pack( or smth like that)
        Gdx.gl.glClearColor(0,  1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        currentStage.act(delta);
        currentStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        currentStage.getViewport().update(width, height, true);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
