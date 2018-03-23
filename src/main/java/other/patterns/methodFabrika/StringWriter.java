package other.patterns.methodFabrika;

public class StringWriter implements Writer {

    @Override
    public void write() {
        System.out.println("I`m a String Writer");
    }
}
