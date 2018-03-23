package other.patterns.Game.Factories;

import other.patterns.Game.Factory;
import other.patterns.Game.enemy.Enemy;
import other.patterns.Game.enemy.Shadow;

public class HardLvl implements Factory {


    @Override
    public Enemy create() {
        return new Shadow();
    }

    @Override
    public int enemySize() {
        return 100;
    }
}
