package view;

import com.badlogic.gdx.scenes.scene2d.Stage;
import viewmodel.GameManager;
import viewmodel.Manager;

public class GameScreen extends Stage {
    private Manager mainManager;
    private GameManager gameManager;
    public Stage currentStage;
    public GameScreen(Manager mainManager, GameManager gameManager) {
        this.mainManager = mainManager;
        this.gameManager = gameManager;

        currentStage = new Stage(mainManager.viewport);
    }
}
