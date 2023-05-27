package viewmodel;

import characters.Enemy;
import characters.Player;
import level.Level;
import map.Board;

import java.util.List;

public class GameManager {
    private Player player;
    private Level level;
    GameManager(int difficulty){
        level = new Level(difficulty);
    }
}
