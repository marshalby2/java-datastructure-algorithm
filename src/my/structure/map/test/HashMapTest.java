package my.structure.map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author marshal
 * @Date 12/10/20 4:01 PM
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
//        map.put(8, "ba");
//        map.put(9, "nine");
        System.out.println(map);
    }
}
