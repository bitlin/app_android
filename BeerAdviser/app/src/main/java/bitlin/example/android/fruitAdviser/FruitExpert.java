package bitlin.example.android.fruitAdviser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anieson on 2017/10/2.
 */

public class FruitExpert {
    List<String> getFruits(String color){
        List<String> fruits=new ArrayList<>(); //利用ArrayList类实例化List集合, ArrayList 为动态数组

        switch (color){
            case "yellow":
                fruits.add("芒果");
                fruits.add("香蕉");
                break;
            case "green":
                fruits.add("青苹果");
                fruits.add("青提子");
                fruits.add("哈密瓜");
                fruits.add("猕猴桃");
                break;
            case "purple":
                fruits.add("葡萄");
                fruits.add("樱桃");
                fruits.add("蓝莓");
                break;
        }
        return fruits;
    }
}
