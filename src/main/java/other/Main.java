package other;

import other.patterns.methodFabrika.FactoryMethod;
import other.patterns.methodFabrika.Writer;

public class Main {
    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();
        Writer writer = factoryMethod.getWriter(12);
        writer.write();
    }
}
