package view;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import viewmodel.GameManager;
import viewmodel.Manager;

public class GameScreen extends StageWrapper{
    private GameManager gameManager;
    public GameScreen(GameManager gameManager) {
        super();
        this.gameManager = gameManager;
        currentStage = new Stage();
    }

    private void loadScene(){

    }

}
