package other.patterns.builder;

import other.patterns.builder.builder.Camp;
import other.patterns.builder.builder.builder.CampBuilder;
import other.patterns.builder.builder.builder.HouseWithGoodsBuilder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.setType("house");
        HouseWithGoodsBuilder builder = new HouseWithGoodsBuilder();
        director.constructBuilder(builder);
        //C//amp camp = builder.getCamp();
       // System.out.println(camp);
    }
}
