package my.structure.map.test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Description TODO
 * @Author marshal
 * @Date 20/10/20 9:36 PM
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(5, "banana");
        map.put(1, "apple");
        map.put(2, "orange");
        map.put(4, "lemon");
        map.put(3, "peach");
        System.out.println(map);
    }
}
