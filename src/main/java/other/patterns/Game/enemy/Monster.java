package other.patterns.Game.enemy;

public class Monster implements Enemy {

    @Override
    public void roar() {
        System.out.println("Roar!!! I`m an Monster");
    }

    @Override
    public void giveMeYourSoul() {
        System.out.println("You are killed by Monster");
    }
}
