package other.patterns.abstractFabrica;

import lombok.Data;
import other.patterns.abstractFabrica.interfaces.Chair;
import other.patterns.abstractFabrica.interfaces.Table;

import java.util.ArrayList;
import java.util.List;

@Data
public class Home {

    private List<Table> tableList;
    private List<Chair> chairList;

    private Home() {
        tableList = new ArrayList<>();
        chairList = new ArrayList<>();
    }

    private static Home instance;

    public synchronized static Home getInstance() {
        if (instance == null) {
            synchronized (Home.class) {
                if (instance == null) {
                    return instance = new Home();
                }
            }
        }
        return instance;
    }

    public void addChair(Chair chair) {
        chairList.add(chair);
    }

    public void addTable(Table table) {
        tableList.add(table);
    }
}
