package other.patterns.methodFabrika.fab;

import other.patterns.methodFabrika.Button;
import other.patterns.methodFabrika.Window;
import other.patterns.methodFabrika.WindowsWIndow;

public class WindowsFactory implements Factory {

    private WindowsWIndow windowsWIndow;

    public WindowsFactory() {
        windowsWIndow = new WindowsWIndow();
    }

    @Override
    public Window createWindow() {
        return windowsWIndow;
    }

}
