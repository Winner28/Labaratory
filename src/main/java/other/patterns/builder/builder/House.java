package other.patterns.builder.builder;

import lombok.ToString;
import other.patterns.builder.builder.goods.Goods;

@ToString
public class House {

    private int walls;
    private String name;
    private Goods good;

    public House() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setWalls(int walls) {
        this.walls = walls;
    }

    public void setGood(Goods good) {
        this.good = good;
    }
}
