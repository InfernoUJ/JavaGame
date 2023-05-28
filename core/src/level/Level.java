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
    public Level(int difficulty) {
        board = createAndFillBoard();
    }

    public void startLevel() {

    }

    private Board createAndFillBoard(){
        /*
            @TODO
                -think about where to fill board
                 maybe in BlockOfTilesSupplier
         */
        BlockOfTilesSupplier blockSupllier = new BlockOfTilesSupplier();
        int dy = Gdx.graphics.getHeight()/5;
        int dx = Gdx.graphics.getWidth()/13;
        Board board = new Board();
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 5; j++){
                board.placeBlock(blockSupllier.generateBlock(dx*j + dx/2, dy*i + dy/2), j, i);
            }
        }

        board.placeBlock(new PlayerSpawnerBlock(dx*2+dx/2, dy + dy/2), 2, 1);
        /* @TODO
             -change player initialisation
         */
        player = new Player(dx*2+dx/2, dy + dy/2);
        return board;
    }
}
