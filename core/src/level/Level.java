package level;

import characters.Enemy;
import characters.Player;
import map.Board;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public Board board;
    public List<Enemy> enemies = new ArrayList<>();
    public Player player;

    public Level(int difficulty) {
        board = new Board();
    }


    public void startLevel() {

    }

}
