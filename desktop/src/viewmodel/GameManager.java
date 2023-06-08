package viewmodel;

import characters.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.Viewport;
import mainGame.Game;
import view.GameScreen;


public class GameManager {
    private final Game game;
    private final Manager mainManager;
    private final Screen gameScreen;
    GameManager(Manager mainManager){
        game = new Game();
        game.startGame();
        this.mainManager = mainManager;
        gameScreen = new GameScreen(this);
    }
    public Player getPlayer() {
        return game.getCurrentLevel().player;
    }

    public Viewport getViewport(){
        return mainManager.viewport;
    }

    public void processKeyDown(int keyCode) {
        if(keyCode == Input.Keys.W){

        }
    }

    public Screen getGameScreen(){
        return gameScreen;
    }
}
