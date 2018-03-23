package other.patterns.Game;

import other.patterns.Game.GameObjects.GameObjects;
import other.patterns.Game.enemy.Enemy;

import java.util.List;

public class Park {
    private List<Enemy> enemies;
    private List<GameObjects> gameObjects;

    public Park(List<Enemy> enemies, List<GameObjects> gameObjects) {
        this.enemies = enemies;
        this.gameObjects = gameObjects;
    }
}
