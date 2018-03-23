package other.patterns.abstractFabrica;

import other.patterns.abstractFabrica.FurnitureFactories.ModernFactory;
import other.patterns.abstractFabrica.FurnitureFactories.OldFactory;
import other.patterns.abstractFabrica.FurnitureFactories.VictorianFactory;
import other.patterns.abstractFabrica.interfaces.FurnitureFactory;

import java.util.Arrays;
import java.util.function.Supplier;

public class User {
    public static void main(String[] args) {
        System.out.println("Hello! What of type of furnuture you want?");
        FurnitureFactory furnitureFactory = furniterFactoryGetter(ModernFactory.class).get();
        Home home = Home.getInstance();
        for (int i = 0; i < 10; i++) {
            home.addChair(furnitureFactory.createChair());
            home.addTable(furnitureFactory.createTable());
        }

        System.out.println(home);

    }

    private static Supplier<FurnitureFactory> furniterFactoryGetter(Class<?> classs) {
        return () -> {
            if (classs.equals(VictorianFactory.class)) {
                return new VictorianFactory();
            } else if (classs.equals(ModernFactory.class)) {
                return new ModernFactory();
            } else if (classs.equals(OldFactory.class)) {
                return new OldFactory();
            }
            throw new RuntimeException("Bad Factory class;");
        };
    }

}
