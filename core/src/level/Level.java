package level;

import characters.Enemy;
import characters.Player;
import map.Board;
import projectiles.Projectile;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public Board board;
    public List<Enemy> enemies = new ArrayList<>();
    public Player player;
    public List<Projectile> projectiles = new ArrayList<>();
    public Level(int difficulty) {
        board = new Board();
    }


    public void startLevel() {

    }

}
