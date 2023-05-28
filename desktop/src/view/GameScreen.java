package view;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import viewmodel.GameManager;
import viewmodel.Manager;

public class GameScreen extends StageWrapper{
    private GameManager gameManager;
    private Hero hero;

    public GameScreen(GameManager gameManager) {
        super();
        this.gameManager = gameManager;
        currentStage = new Stage(gameManager.getViewport());
        hero = new Hero(gameManager);
        hero.addListener(new InputListener(){
            @Override
            public boolean keyDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, int keycode) {
                hero.gameManager.processKeyDown(keycode);
                return true;
            }
        });
    }


    private void loadScene(){

    }

}
