package other.patterns.methodFabrika;

public class WindowsWIndow implements Window {

    @Override
    public Button create() {
        return new WindowsButton();
    }
}
