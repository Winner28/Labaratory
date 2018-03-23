package other.patterns.methodFabrika;

public class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering for Windows");
    }

    @Override
    public String action(String action) {
        return "Windows: " + action;
    }
}
