package viewmodel;

import characters.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.Viewport;
import mainGame.Game;
import view.GameScreen;


public class GameManager {
    private final Game game;
    private final Manager mainManager;
    private final Screen gameScreen;
    private final InputProcessor controller;
    GameManager(Manager mainManager){
        game = new Game();
        game.startGame();

        controller = new Controller(this);
        Gdx.input.setInputProcessor(controller);

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
        //System.out.println("Updated " + getHeroXCoordinate() +" "+ getHeroYCoordinate());
        if(keyCode == Input.Keys.W) {
            game.getCurrentLevel().player.setyCenterCoordinate(getHeroYCoordinate() + 5);
        }
        if(keyCode == Input.Keys.S) {
            game.getCurrentLevel().player.setyCenterCoordinate(getHeroYCoordinate() - 5);
        }
        if(keyCode == Input.Keys.D) {
            game.getCurrentLevel().player.setxCenterCoordinate(getHeroXCoordinate() + 5);
        }
        if(keyCode == Input.Keys.A) {
            game.getCurrentLevel().player.setxCenterCoordinate(getHeroXCoordinate() - 5);
        }
    }

    public Screen getGameScreen(){
        // is there rvalue in Java?
        // otherwise this method is meaningless
        return gameScreen;
    }

    public float getHeroXCoordinate(){
        return game.getCurrentLevel().player.getxCenterCoordinate();
    }

    public float getHeroYCoordinate(){
        return game.getCurrentLevel().player.getyCenterCoordinate();
    }
}
