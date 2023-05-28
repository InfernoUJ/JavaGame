package level;

import characters.Enemy;
import characters.Player;
import com.badlogic.gdx.Gdx;
import map.Board;
import projectiles.Projectile;
import specficBlockOfTiles.PlayerSpawnerBlock;
import suppliers.BlockOfTilesSupplier;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public Board board;
    public List<Enemy> enemies = new ArrayList<>();
    public Player player;
    public List<Projectile> projectiles = new ArrayList<>();
    private Level() {

    }

    public void startLevel() {

    }


}
