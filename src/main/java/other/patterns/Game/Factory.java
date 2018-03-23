package other.patterns.Game;

import other.patterns.Game.enemy.Enemy;

public interface Factory {
    Enemy create();
    int enemySize();
}
