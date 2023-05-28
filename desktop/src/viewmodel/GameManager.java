package viewmodel;

import characters.Player;
import level.Level;

public class GameManager {
    private Player player;
    private Level level;
    GameManager(int difficulty){
        level = new Level(difficulty);
    }
}
