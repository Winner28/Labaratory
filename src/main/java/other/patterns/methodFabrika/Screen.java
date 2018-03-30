package other.patterns.methodFabrika;

import other.patterns.methodFabrika.fab.Factory;
import other.patterns.methodFabrika.fab.LinuxFactory;

import java.util.function.Consumer;

public class Screen {
    public static void main(String[] args) {
        Factory factory = new LinuxFactory();
        Window window = factory.createWindow();
       action(button ->  {
           button.render();
           button.action("Simple action");
           },
               window.create());
    }

    public static void action(Consumer<Button> buttonConsumer, Button button) {
        buttonConsumer.accept(button);
    }
}
