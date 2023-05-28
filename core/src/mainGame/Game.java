package mainGame;

import level.Level;

public class Game {
    private Level level;
    private int levelNumber;
    public Level generateLevel() {
        return null;
    }
    public Level getCurrentLevel() {
        return level;
    }
    public int getCurrentLevelNumber() {
        return levelNumber;
    }

    public void startGame(){
        if (level != null) {
            throw new IllegalStateException("game already started, cannot start again");
        }
        levelNumber = 1;
        level = new Level(levelNumber);
    }

    public void advanceToTheNextLevel() {
        if(level==null) {
            throw new IllegalStateException("cannot advance to the next level, game finished or not started");
        }
        levelNumber++;
        level = new Level(levelNumber);
    }
    public boolean isGameOver() {
        if(level == null) {
            throw new IllegalStateException("level is null");
        }
        if(level.player.getHealthPoints() > 0) {
            return false;
        }
        return true;
    }//returns if our character is dead or not

}
