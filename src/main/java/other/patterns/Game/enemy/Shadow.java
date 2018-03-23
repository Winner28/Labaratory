package other.patterns.Game.enemy;

public class Shadow implements Enemy {

    @Override
    public void roar() {
        System.out.println("Roar!! I`m an shadow");
    }

    @Override
    public void giveMeYourSoul() {
        System.out.println("Killed!!!");
    }
}
