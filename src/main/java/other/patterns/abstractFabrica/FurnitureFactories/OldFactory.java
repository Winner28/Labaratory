package other.patterns.abstractFabrica.FurnitureFactories;

import other.patterns.abstractFabrica.interfaces.Chair;
import other.patterns.abstractFabrica.interfaces.FurnitureFactory;
import other.patterns.abstractFabrica.interfaces.Table;
import other.patterns.abstractFabrica.old.OldChair;
import other.patterns.abstractFabrica.old.OldTable;

public class OldFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new OldChair();
    }

    @Override
    public Table createTable() {
        return new OldTable();
    }
}
