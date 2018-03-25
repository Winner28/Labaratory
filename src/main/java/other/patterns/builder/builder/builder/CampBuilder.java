package other.patterns.builder.builder.builder;

import other.patterns.builder.builder.Camp;
import other.patterns.builder.builder.goods.Goods;


public class CampBuilder implements Builder {

    private Camp camp;

    @Override
    public void addGood(Goods goods) {
        camp.setGood(goods);
    }

    @Override
    public void setWalls(int walls) {
        camp.setWalls(walls);
    }

    @Override
    public void setHouseName(String campName) {
        camp.setName(campName);
    }

    public Camp getCamp() {
        return camp;
    }
}
