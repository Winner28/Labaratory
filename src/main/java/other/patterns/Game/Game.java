package other.patterns.Game;

import other.patterns.Game.Factories.EzLvl;
import other.patterns.Game.GameObjects.Bench;
import other.patterns.Game.enemy.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    private Park park;
    private Hero gamer;


    public Game(Factory enemyFactory) {
        //park = new Park();
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < enemyFactory.enemySize(); i++) {
            enemies.add(enemyFactory.create());
        }
        park = new Park(enemies, Collections.singletonList(new Bench()));
        gamer = new Hero();
    }
}
