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
    private Map<Integer, Mover> mover = new HashMap();
    private void infiniteLoop(int keyCode){
        if(!mover.containsKey(keyCode)){
            mover.put(keyCode, new Mover<>(gameManager::processKeyDown, keyCode));
            mover.get(keyCode).start();
        }
        else{
            mover.get(keyCode).resumeWork();
            //mover.get(keyCode).run();
        }
    }

    public Controller(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean keyDown(int keyCode) {
        // TODO:maybe change from void type to boolean
        System.out.println("Updated " + gameManager.getHeroXCoordinate() +" "+ gameManager.getHeroYCoordinate());
        infiniteLoop(keyCode);
        return true;
    }

    @Override
    public boolean keyUp(int keyCode){
        System.out.println("Upped " + keyCode);
        mover.get(keyCode).stopWork();
        return true;
    }

}
