package viewmodel;

import characters.Enemy;
import characters.Person;
import characters.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.Coordinates;
import mainGame.Game;
import projectiles.Projectile;
import view.GameScreen;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;


public class GameManager {
    public final Game game;
    private final Manager mainManager;
    public final GameScreen gameScreen = new GameScreen(this);
    private Controller controller;

    GameManager(Manager mainManager){
        game = new Game();
        game.startGame();

        this.mainManager = mainManager;
        loadGameScreen();
    }

    public Player getPlayer() {
        return game.getCurrentLevel().player;
    }

    public Viewport getViewport(){
        return mainManager.viewport;
    }

    private void loadGameScreen(){
        controller = new Controller(this);
        Gdx.input.setInputProcessor(controller);
        gameScreen.loadScene();
        addEnemies();
    }


    public float getHeroXCoordinate(){
        return game.getCurrentLevel().player.getxCenterCoordinate();
    }

    public float getHeroYCoordinate(){
        return game.getCurrentLevel().player.getyCenterCoordinate();
    }

    public void addEnemies() {
        for(Person enemy : game.getCurrentLevel().enemies) {
            gameScreen.addEnemy(enemy);
        }
        gameScreen.loadEnemies();
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
            if(Coordinates.getXDistance(p, getPlayer()) < 10
                    && Coordinates.getYDistance(p, getPlayer()) < 10){
                p.hit(getPlayer());
                gameScreen.removeBullet(p);
                projectilesToRemove.add(p);
                if(getPlayer().getHealthPoints() <= 0){
                    gameLost();
                }
            }
            for(Person enemy : game.getCurrentLevel().enemies) {
                if(Coordinates.getXDistance(p, enemy) < 10
                        && Coordinates.getYDistance(p, enemy) < 10){
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
        mainManager.loadVictoryScreen();
    }
    private void gameLost(){
        mainManager.loadGameOverMenu();
    }

}
