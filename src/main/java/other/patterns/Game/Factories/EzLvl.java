package other.patterns.Game.Factories;

import other.patterns.Game.Factory;
import other.patterns.Game.enemy.Enemy;
import other.patterns.Game.enemy.Monster;

public class EzLvl implements Factory {

    @Override
    public Enemy create() {
        return new Monster();
    }

    @Override
    public int enemySize() {
        return 30;
    }
}
