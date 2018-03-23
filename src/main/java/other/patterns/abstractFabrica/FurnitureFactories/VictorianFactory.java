package other.patterns.abstractFabrica.FurnitureFactories;

import other.patterns.abstractFabrica.interfaces.Chair;
import other.patterns.abstractFabrica.interfaces.FurnitureFactory;
import other.patterns.abstractFabrica.interfaces.Table;
import other.patterns.abstractFabrica.victorian.VictorianChair;
import other.patterns.abstractFabrica.victorian.VictorianTable;

public class VictorianFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
