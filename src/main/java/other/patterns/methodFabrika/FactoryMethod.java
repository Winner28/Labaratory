package other.patterns.methodFabrika;

public class FactoryMethod {
    public Writer getWriter(Object object) {
        if (object instanceof Number) {
            return new NumberWriter();
        }
        if (object instanceof String) {
            return new StringWriter();
        }
        throw new IllegalArgumentException();
    }
}
