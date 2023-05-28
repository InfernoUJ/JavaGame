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

    }

    public void advanceToTheNextLevel() {

    }
    public boolean isGameOver() {
        return false;
    }//returns if our character died or not

}
