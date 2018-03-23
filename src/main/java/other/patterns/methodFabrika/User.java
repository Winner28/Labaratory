package other.patterns.methodFabrika;

public class User {
    public static void main(String[] args) {
        Window window = getWindowForCurrentOS(LinuxWindow.class);
        Button button = window.create();
        System.out.println(button.action("Open Bucket"));
        button.render();
    }

    private static <T extends Window> Window getWindowForCurrentOS(Class<T> tClass) {
        if (tClass.equals(LinuxWindow.class)) {
            return new LinuxWindow();
        } else if (tClass.equals(WindowsWIndow.class)) {
            return new WindowsWIndow();
        }
        throw new RuntimeException("Class expected!");
    }
}
