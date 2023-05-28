package viewmodel;

import characters.Player;
import level.Level;
import mainGame.Game;

public class GameManager {
    private Player player;
    private Level level;
    private Game game;
    GameManager(){
        game = new Game();
        level = game.generateLevel();
    }
}
