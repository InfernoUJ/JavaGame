package viewmodel;

import characters.Player;
import level.Level;
import suppliers.LevelSupplier;

public class GameManager {
    private Player player;
    private Level level;
    private LevelSupplier levelSupplier;
    GameManager(){
        levelSupplier = new LevelSupplier();
        level = levelSupplier.generateLevel();
    }
}
