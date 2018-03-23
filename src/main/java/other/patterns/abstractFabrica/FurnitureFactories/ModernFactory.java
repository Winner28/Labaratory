package other.patterns.abstractFabrica.FurnitureFactories;

import other.patterns.abstractFabrica.interfaces.Chair;
import other.patterns.abstractFabrica.interfaces.FurnitureFactory;
import other.patterns.abstractFabrica.interfaces.Table;
import other.patterns.abstractFabrica.modern.ModernChair;
import other.patterns.abstractFabrica.modern.ModernTable;

public class ModernFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
