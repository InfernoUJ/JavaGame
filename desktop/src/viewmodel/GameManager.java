package viewmodel;

import characters.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.viewport.Viewport;
import level.Level;
import mainGame.Game;

public class GameManager {
    private final Game game;
    private final Manager mainManager;
    GameManager(Manager mainManager){
        game = new Game();
        this.mainManager = mainManager;
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
}
