package viewmodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.OurGame;
import view.StartMenuScreen;

public class Manager {
    final OurGame game;
    public Screen currentScreen = null;
    public Viewport viewport;
    public Skin skin;
    private Screen startMenuScreen;
    private Screen gameScreen;
    private GameManager gameManager;

    public Manager(final OurGame game) {
        this.game = game;

        viewport = new ScreenViewport();
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        loadStartMenu();

        //currentStage = startStage.getStage();


    }
    private void loadStartMenu(){
        startMenuScreen = new StartMenuScreen(this);
        //startMenuScreen.show();
        currentScreen = startMenuScreen;
    }
    public void exitGame(){
        dispose();
        Gdx.app.exit();
    }
    public void startGame(){
        startMenuScreen.dispose();
        gameManager = new GameManager(this);
        currentScreen = gameManager.getGameScreen();
    }

//    @Override
//    public void render(float delta){
//        super.render(delta);
//        ScreenUtils.clear(0, 0.2f, 0.1f, 1);
//
//        currentStage.act(delta);
//        currentStage.draw();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        super.resize(width, height);
//        currentStage.getViewport().update(width, height, true);
//    }

    public void dispose() {
        // @TODO
    }
}
