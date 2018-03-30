package other.patterns.methodFabrika.fab;

import other.patterns.methodFabrika.Button;
import other.patterns.methodFabrika.LinuxWindow;
import other.patterns.methodFabrika.Window;

public class LinuxFactory implements Factory {

    private LinuxWindow linuxWindow;

    public LinuxFactory() {
        linuxWindow = new LinuxWindow();
    }

    @Override
    public Window createWindow() {
        return linuxWindow;
    }

}
