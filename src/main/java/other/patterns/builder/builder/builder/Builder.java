package other.patterns.builder.builder.builder;

import other.patterns.builder.builder.goods.Goods;

public interface Builder {
    void addGood(final Goods goods);
    void setWalls(final int walls);
    void setHouseName(final String houseName);

}
