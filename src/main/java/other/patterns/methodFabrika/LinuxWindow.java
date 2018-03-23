package other.patterns.methodFabrika;

public class LinuxWindow implements Window {

    @Override
    public Button create() {
        return new LinuxButton();
    }
}
