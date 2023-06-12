package viewmodel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.OurGame;
import view.GameOverScreen;
import view.StartMenuScreen;
import view.VictoryScreen;

public class Manager {
    final OurGame game;
    public Screen currentScreen = null;
    public Screen vicrotyScreen = null;
    public Viewport viewport;
    public Skin skin;
    private Screen startMenuScreen;
    private Screen gameOverScreen;
    private GameManager gameManager;

    public Manager(final OurGame game) {
        this.game = game;

        viewport = new ScreenViewport();
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        loadStartMenu();

        //currentStage = startStage.getStage();


    }
    public void loadStartMenu(){
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

    public void dispose() {
        // @TODO
    }

    public void nextLevel() {
        vicrotyScreen.dispose();
        gameManager.nextLevel();
        currentScreen = gameManager.getGameScreen();
    }
    public void loadVictoryScreen(){
        vicrotyScreen = new VictoryScreen(this);
        currentScreen = vicrotyScreen;
    }

    public void loadGameOverMenu() {
        gameOverScreen = new GameOverScreen(this);
        currentScreen = gameOverScreen;
    }
}
