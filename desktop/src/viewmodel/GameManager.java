package viewmodel;

import characters.Person;
import characters.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import mainGame.Game;
import view.Character;
import view.GameScreen;

import java.util.ArrayList;
import java.util.List;


public class GameManager {
    private final Game game;
    public final int maxHealthPoints = 100;
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
        System.out.println(numberOfEnemies());
    }
    public Player getPlayer() {
        return game.getCurrentLevel().player;
    }
    public int numberOfEnemies() {
        return game.getCurrentLevel().enemies.size();
    }

    public Viewport getViewport(){
        return mainManager.viewport;
    }

    public void processKeyDown(int keyCode) {
        //System.out.println("Updated " + getHeroXCoordinate() +" "+ getHeroYCoordinate());
        if(keyCode == Input.Keys.W) {
            game.getCurrentLevel().player.setyCenterCoordinate(getHeroYCoordinate() + getPlayer().getSpeed());
        }
        if(keyCode == Input.Keys.S) {
            game.getCurrentLevel().player.setyCenterCoordinate(getHeroYCoordinate() - getPlayer().getSpeed());
        }
        if(keyCode == Input.Keys.D) {
            game.getCurrentLevel().player.setxCenterCoordinate(getHeroXCoordinate() + getPlayer().getSpeed());
        }
        if(keyCode == Input.Keys.A) {
            game.getCurrentLevel().player.setxCenterCoordinate(getHeroXCoordinate() - getPlayer().getSpeed());
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

    public List<Character> loadEnemies() {
        List<Character> enemies = new ArrayList<>();
        for(Person enemy : game.getCurrentLevel().enemies) {
            Character character = new Character(this, enemy, new TextureRegion(new Texture("enemy1.png")));
            enemies.add(character);
        }
        return enemies;
    }

    public void makeShooting(float delta){
        getPlayer().decrementBigAoeCd(delta);
        getPlayer().decrementCd(delta);
        //getPlayer().shoot();

    }
}
