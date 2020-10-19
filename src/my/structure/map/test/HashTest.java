package my.structure.map.test;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author marshal
 * @Date 19/10/20 8:48 AM
 */
public class HashTest {
    public static void main(String[] args) {
//        System.out.println("name".hashCode());
//        System.out.println(hash("name"));
        System.out.println(hash("name") & 7);
        System.out.println(hash("name") % 8);
        System.out.println(hash("123456") & 7);
        System.out.println(hash("123456") % 8);
        System.out.println(hash(1) & 7);
        System.out.println(hash(1) % 8);
//        System.out.println(hash(10.0f) & 8);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
