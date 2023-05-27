package viewmodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.OurGame;
import view.GameScreen;
import view.StartMenuScreen;

public class Manager extends ScreenAdapter{
    final OurGame game;
    public Stage currentStage;
    public Viewport viewport;
    public Skin skin;
    StartMenuScreen startStage;

    public Manager(final OurGame game) {
        this.game = game;

        viewport = new ScreenViewport();
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        startStage = new StartMenuScreen(this);
        currentStage = startStage.currentStage;

        Gdx.input.setInputProcessor(currentStage);
    }
    public void exitGame(){
        Gdx.app.exit();
    }
    public void startGame(){
        currentStage.dispose();
        currentStage = new GameScreen(this, new GameManager()).currentStage;
        Gdx.input.setInputProcessor(currentStage);
    }

    @Override
    public void render(float delta){
        super.render(delta);
        ScreenUtils.clear(0, 0.2f, 0.1f, 1);

        currentStage.act();
        currentStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        currentStage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        super.dispose();
        currentStage.dispose();
        startStage.dispose();
    }
}
