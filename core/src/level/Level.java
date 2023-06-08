package level;

import characters.Enemy;
import characters.Player;
import map.BlockOfTiles;
import map.Board;
import map.Tile;
import projectiles.Projectile;
import specificTiles.EnemySpawner;
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
        blockOfTilesSupplier.setHealingCampChance(Math.max(Math.min(5,100 - blockOfTilesSupplier.getTrapChance() - blockOfTilesSupplier.getEnemyChance()),0));
        blockOfTilesSupplier.setWallChance(Math.max(Math.min(3,100 - blockOfTilesSupplier.getEnemyChance() - blockOfTilesSupplier.getTrapChance() - blockOfTilesSupplier.getHealingCampChance()),0));
        while(enemies.isEmpty()) {
            player = null;
            board = new Board(blockOfTilesSupplier);
            placeAllCharacters();
        }
    }


    private void placeAllCharacters() {
        for(BlockOfTiles blockOfTiles : board.blocks) {
            for(Tile tile: blockOfTiles.internalTiles) {
                if(tile instanceof EnemySpawner) {
                    Enemy enemy = new Enemy((int) tile.getxCenterCoordinate(), (int) tile.getyCenterCoordinate());
                    enemy.level = this;
                    enemies.add(enemy);
                }

            }
        }
        player = new Player(0, 0);
        player.level = this;

    }


}
