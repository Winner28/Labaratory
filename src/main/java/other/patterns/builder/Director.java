package other.patterns.builder;

import other.patterns.builder.builder.builder.Builder;
import other.patterns.builder.builder.builder.CampBuilder;
import other.patterns.builder.builder.builder.HouseWithGoodsBuilder;
import other.patterns.builder.builder.goods.Garage;
import other.patterns.builder.builder.goods.Pool;

public class Director {

    // better to swap String type to ENUM, but i`m lazy =)
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void constructBuilder(Builder build) {
        if (type == null) {
            throw new RuntimeException("Set type first, please!");
        }
        if (type.equals("camp")) {
            build.setHouseName("Camp!");
            build.setWalls(10);
            build.addGood(new Pool());

        } else {
            build.addGood(new Garage());
            build.setHouseName("Good house!");
            build.setWalls(4);
        }
    }
}
