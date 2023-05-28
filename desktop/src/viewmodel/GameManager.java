package viewmodel;

import characters.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.viewport.Viewport;
import level.Level;

public class GameManager {
    private Player player;
    private Level level;
    private Manager mainManager;
    GameManager(int difficulty, Manager mainManager){
        level = new Level(difficulty);
        this.mainManager = mainManager;
    }

    public Player getPlayer() {
        return player;
    }


    public Viewport getViewport(){
        return mainManager.viewport;
    }

    public void processKeyDown(int keyCode) {
        if(keyCode == Input.Keys.W){

        }
    }
}
