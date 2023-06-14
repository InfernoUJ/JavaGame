package viewmodel;

import com.badlogic.gdx.InputAdapter;

import java.util.HashMap;
import java.util.Map;

public class Controller extends InputAdapter {
    /*
        this class implements Observer pattern
        and is responsible for handling user's input

        Unfortunately the keyDown is called only ones,
        so I have to invite my own bicycle
    */
    private final GameManager gameManager;



    public Controller(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean keyDown(int keyCode) {
        for(Direction direction : Direction.values()) {
            if(direction.keyCodes.contains(keyCode)) {
                gameManager.gameScreen.turnOnPlayerMovementInDirection(direction);
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keyCode){
        for(Direction direction : Direction.values()) {
            if(direction.keyCodes.contains(keyCode)) {
                gameManager.gameScreen.turnOffPlayerMovementInDirection(direction);
            }
        }
        return true;
    }



}
