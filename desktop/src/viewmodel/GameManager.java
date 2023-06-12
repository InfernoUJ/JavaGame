package viewmodel;

import characters.Enemy;
import characters.Person;
import characters.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.Coordinates;
import mainGame.Game;
import projectiles.Projectile;
import view.Character;
import view.GameScreen;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class GameManager {
    public final Game game;
    public final int maxHealthPoints = 100;
    private final Manager mainManager;
    private GameScreen gameScreen;
    private Controller controller;
    GameManager(Manager mainManager){
        game = new Game();
        game.startGame();

        this.mainManager = mainManager;
        loadGameScreen();
        //System.out.println(numberOfEnemies());
    }
    private void loadGameScreen(){
        controller = new Controller(this);
        Gdx.input.setInputProcessor(controller);
        gameScreen = new GameScreen(this);
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
        System.out.println("Updated " + getHeroXCoordinate() +" "+ getHeroYCoordinate());
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
        //moveEnemies();
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
        Random r = new Random();
        String[] enemyTexture = {"enemy2_2.png", "enemy2.png", "enemy3.png"};
        for(Person enemy : game.getCurrentLevel().enemies) {
        Character character = new Character(this, enemy, new TextureRegion(new Texture(enemyTexture[r.nextInt(enemyTexture.length)])));
            enemies.add(character);
        }
        return enemies;
    }

    public void makeShooting(float delta){
        decrementAllCD(delta);
        shootAllProjectiles();
        moveAllProjectTiles(delta);
        hitEveryone();
        checkIfEnemiesAreDead();
    }

    private void checkIfEnemiesAreDead() {
        if(game.getCurrentLevel().enemies.isEmpty()) {
            endLevel();
        }
    }

    private void shootAllProjectiles() {
        if(getPlayer().getShootingCooldown() <= 0){
            Person closestEnemy = findClosestEnemy();
            if (closestEnemy == null){
                //throw new RuntimeException("No enemies found");
                endLevel();
                return;
            }
            Projectile p = getPlayer().shoot(Pair.of(closestEnemy.getxCenterCoordinate(), closestEnemy.getyCenterCoordinate()));
            System.out.println("Shooting from " + p.getxCenterCoordinate() +" "+ p.getyCenterCoordinate());
            System.out.println("Shooting to " + p.getDirection().getLeft() +" "+ p.getDirection().getRight());
            getPlayer().resetCd();
            gameScreen.addBullet(p);
        }

        for(Person enemy : game.getCurrentLevel().enemies) {
            if(enemy.getShootingCooldown() <= 0){
                Projectile p = enemy.shoot(Pair.of(getHeroXCoordinate(), getHeroYCoordinate()));
                enemy.resetCd();
                gameScreen.addBullet(p);
            }
        }
    }

    private Person findClosestEnemy() {
        Person closestEnemy = null;
        for (Person enemy : game.getCurrentLevel().enemies) {
            if (closestEnemy == null) {
                closestEnemy = enemy;
            } else if(Coordinates.getDistance(getPlayer(), enemy) < Coordinates.getDistance(getPlayer(), closestEnemy)) {
                closestEnemy = enemy;
            }
        }
        return closestEnemy;
    }

    private void decrementAllCD(float delta){
        getPlayer().decrementBigAoeCd(delta);
        getPlayer().decrementCd(delta);
        for(Person enemy : game.getCurrentLevel().enemies) {
            enemy.decrementCd(delta);
        }
    }

    private void moveAllProjectTiles(float delta){
        List<Projectile> toRemove = new ArrayList<>();
        for (Projectile p : game.getCurrentLevel().projectiles) {
            p.move(delta);
            if(isOutOfMap(p)){
                toRemove.add(p);
                gameScreen.removeBullet(p);
            }
        }
        game.getCurrentLevel().projectiles.removeAll(toRemove);
    }

    private boolean isOutOfMap(Coordinates p){
        return p.getxCenterCoordinate() < 0 || p.getxCenterCoordinate() > 1920
                || p.getyCenterCoordinate() < 0 || p.getyCenterCoordinate() > 1080;
    }

    private void hitEveryone(){
        List<Projectile> projectilesToRemove = new ArrayList<>();
        List<Person> enemiesToRemove = new ArrayList<>();
        for (Projectile p : game.getCurrentLevel().projectiles) {
            if(Coordinates.getXDistance(p, getPlayer()) < 5
                    && Coordinates.getYDistance(p, getPlayer()) < 5){
                p.hit(getPlayer());
                gameScreen.removeBullet(p);
                projectilesToRemove.add(p);
                if(getPlayer().getHealthPoints() <= 0){
                    // TODO: add game over screen
                    // mainManager.setScreen(mainManager.gameOverScreen);
                }
            }
            for(Person enemy : game.getCurrentLevel().enemies) {
                if(Coordinates.getXDistance(p, enemy) < 5
                        && Coordinates.getYDistance(p, enemy) < 5){
                    p.hit(enemy);
                    if(enemy.getHealthPoints() <= 0){
                        enemiesToRemove.add(enemy);
                        gameScreen.removeEnemy(enemy);
                    }
                    gameScreen.removeBullet(p);
                    projectilesToRemove.add(p);
                }
            }
        }
        game.getCurrentLevel().projectiles.removeAll(projectilesToRemove);
        game.getCurrentLevel().enemies.removeAll(enemiesToRemove);
    }

    public void nextLevel() {
        game.advanceToTheNextLevel();
        loadGameScreen();
    }

    public void moveEnemies(){
        for(Enemy enemy : game.getCurrentLevel().enemies) {
            enemy.moveToPlayer(getPlayer());
        }
    }
    private void endLevel(){
        clean();
        mainManager.loadVictoryScreen();
    }
    private void clean(){
        controller.stopAllMovers();
    }
}
