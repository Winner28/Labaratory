package other.patterns.builder.builder;

import lombok.Data;
import other.patterns.builder.builder.goods.Goods;

@Data
public class Camp {

    private int walls;
    private String name;
    private Goods good;


}
