package other.patterns.builder.builder.builder;

import other.patterns.builder.builder.House;
import other.patterns.builder.builder.goods.Goods;

public class HouseWithGoodsBuilder implements Builder {

    private House house;

    @Override
    public void addGood(Goods goods) {
        house.setGood(goods);
    }

    @Override
    public void setWalls(int walls) {
        house.setWalls(walls);
    }

    @Override
    public void setHouseName(String houseName) {
        house.setName(houseName);
    }

    public House getHouse() {
        return house;
    }
}
