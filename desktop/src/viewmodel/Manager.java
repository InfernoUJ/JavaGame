package viewmodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.OurGame;
import view.GameScreen;
import view.StageWrapper;
import view.StartMenuScreen;

public class Manager {
    final OurGame game;
    public Screen currentScreen = null;
    public Viewport viewport;
    public Skin skin;
    private Screen startMenuScreen;
    private Screen gameScreen;

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
        //currentStage.dispose();
        // gameScreen = new GameScreen(new GameManager( this));
        //currentStage = gameScreen.getStage();
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
