package viewmodel;

import characters.Enemy;
import characters.Person;
import characters.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;
import coreStructures.Coordinates;
import mainGame.Game;
import projectiles.Projectile;
import view.BulletDrawable;
import view.CharacterDrawable;
import view.GameScreen;
import org.apache.commons.lang3.tuple.Pair;
import view.SimpleBoundedActor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameManager {
    public final Game game;
    private final Manager mainManager;
    private Character hero = null;
    private List<Character> enemies = new ArrayList<>();
    private final SupplierForBullets supplierForBullets = new SupplierForBullets();
    private final SupplierForCharacters supplierForCharacters = new SupplierForCharacters();
    private List<Bullet> bullets = new ArrayList<>();
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
        addHero();
        addEnemies();
    }

    private void addHero() {
        Pair<Character, CharacterDrawable> heroEntities = supplierForCharacters.createPair(getPlayer(), new TextureRegion(new Texture("hero2.png")));
        this.hero = heroEntities.getLeft();
        gameScreen.addHero(heroEntities.getRight());
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
    }

    public float getHeroXCoordinate(){
        return game.getCurrentLevel().player.getxCenterCoordinate();
    }

    public float getHeroYCoordinate(){
        return game.getCurrentLevel().player.getyCenterCoordinate();
    }

    public void addEnemies() {
        Random r = new Random();
        String[] enemyTexture = {"enemy2_2.png", "enemy2.png", "enemy3.png"};
        for(Person enemy : game.getCurrentLevel().enemies) {
            Pair<Character, CharacterDrawable> enemyEntities = supplierForCharacters.createPair(enemy, new TextureRegion(new Texture(enemyTexture[r.nextInt(enemyTexture.length)])));
            enemies.add(enemyEntities.getLeft());
            gameScreen.addEnemy(enemyEntities.getRight());
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
        if(enemies.isEmpty()){
            endLevel();
        }
    }
    private TextureRegion createBulletTexture(float radius) {
        int diameter = (int) (2 * radius);
        Pixmap pixmap = new Pixmap(diameter, diameter, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fillCircle((int)radius, (int)radius, (int) radius);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegion(texture);
    }
    private void shootAllProjectiles() {
        if(getPlayer().getShootingCooldown() <= 0){
            Character closestEnemy = findClosestEnemy();
            if (closestEnemy == null){
                //throw new RuntimeException("No enemies found");
                endLevel();
                return;
            }
            Projectile p = getPlayer().shoot(Pair.of(closestEnemy.getX(), closestEnemy.getY()));
            System.out.println("Shooting from " + p.getxCenterCoordinate() +" "+ p.getyCenterCoordinate());
            System.out.println("Shooting to " + p.getDirection().getLeft() +" "+ p.getDirection().getRight());
            Pair<Bullet, BulletDrawable> bulletEntities= supplierForBullets.createPair(p, createBulletTexture(5));
            bullets.add(bulletEntities.getLeft());
            gameScreen.addBullet(bulletEntities.getRight());
            getPlayer().resetCd();
        }

        for(Person enemy : game.getCurrentLevel().enemies) {
            if(enemy.getShootingCooldown() <= 0){
                Projectile p = enemy.shoot(Pair.of(getHeroXCoordinate(), getHeroYCoordinate()));
                Pair<Bullet, BulletDrawable> bulletEntities= supplierForBullets.createPair(p, createBulletTexture(5));
                bullets.add(bulletEntities.getLeft());
                gameScreen.addBullet(bulletEntities.getRight());
                enemy.resetCd();
            }
        }
    }

    private Character findClosestEnemy() {
        Character closestEnemy = null;
        for (Character enemy : enemies) {
            if (closestEnemy == null) {
                closestEnemy = enemy;
            } else if(Coordinates.getDistance(getPlayer(), enemy.getCoordinates()) < Coordinates.getDistance(getPlayer(), closestEnemy.getCoordinates())) {
                closestEnemy = enemy;
            }
        }
        return closestEnemy;
    }

    private void decrementAllCD(float delta){
        getPlayer().decrementBigAoeCd(delta);
        getPlayer().decrementCd(delta);
        for(Character enemy : enemies) {
            enemy.myPerson.decrementCd(delta);
        }
    }

    private void moveAllProjectTiles(float delta){
        List<Bullet> toRemove = new ArrayList<>();
        for (Bullet bullet : bullets) {
            bullet.myProjectile.move(delta);
            if(isOutOfMap(bullet)){
                toRemove.add(bullet);
                //gameScreen.removeBullet(p);
            }
        }
        game.getCurrentLevel().projectiles.removeAll(toRemove);
    }

    private boolean isOutOfMap(SimpleBounded p){
        return p.intersectsX(1920) || p.intersectsY(1080) || p.intersectsX(0) || p.intersectsY(0);
    }

    private void hitEveryone(){
        List<Projectile> projectilesToRemove = new ArrayList<>();
        List<Person> enemiesToRemove = new ArrayList<>();
        for (Projectile p : game.getCurrentLevel().projectiles) {
            if(Coordinates.getXDistance(p, getPlayer()) < 10
                    && Coordinates.getYDistance(p, getPlayer()) < 10){
                p.hit(getPlayer());
                //gameScreen.removeBullet(p);
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
                        //gameScreen.removeEnemy(enemy);
                    }
                    //gameScreen.removeBullet(p);
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
    private void gameLost(){
        clean();
        mainManager.loadGameOverMenu();
    }
    private void clean(){
        // TODO: check it is needed
        //  - controller.stopAllMovers();
    }
}
