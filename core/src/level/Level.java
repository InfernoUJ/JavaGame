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
    private BlockOfTilesSupplier blockOfTilesSupplier;
    public Level(int difficulty) {
        blockOfTilesSupplier = new BlockOfTilesSupplier();
        blockOfTilesSupplier.setEnemyChance(Math.min(difficulty,100));
        blockOfTilesSupplier.setTrapChance(Math.min(difficulty,100 - blockOfTilesSupplier.getEnemyChance()));
        blockOfTilesSupplier.setHealingCampChance(Math.max(5,100 - blockOfTilesSupplier.getTrapChance()));
        blockOfTilesSupplier.setWallChance(3);
        while(enemies.isEmpty()) {
            player = null;
            board = new Board(blockOfTilesSupplier);
            placeAllCharacters();
        }
    }


    private void placeAllCharacters() {


    }


}
