package other.patterns;

import java.util.function.Function;

public class Singleton {

    private Singleton() {

    }

    private static Singleton instance;

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                synchronized (Singleton.class) {
                    return instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public <T,R> R getR(Function<T,R> function, T t) {
        return function.apply(t);
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton anotherSingleton = Singleton.getInstance();
        if (!singleton.equals(anotherSingleton)) {
            throw new RuntimeException("Not equals");
        }
        Function<Integer, String> func = String::valueOf;
        String singletonR = singleton.getR(func, 15);
        System.out.println(singletonR);
    }
}
