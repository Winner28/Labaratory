package other.patterns.methodFabrika;

public class LinuxButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering for Linux");
    }

    @Override
    public String action(String action) {
        System.out.println("Linux: " + action);
        return "Linux: " + action;
    }
}
