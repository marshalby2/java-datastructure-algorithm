package my.structure.map.test;

import my.structure.map.impl.MyHashTable;

/**
 * @Description TODO
 * @Author marshal
 * @Date 20/10/20 10:06 AM
 */
public class MyHashTableTest {
    public static void main(String[] args) {

        MyHashTable<Integer, String> table = new MyHashTable<>();
        System.out.println(table.put(1, "China"));
        System.out.println(table.put(2, "American"));
        System.out.println(table.put(3, "Russia"));
        System.out.println(table.put(4, "French"));
        System.out.println(table.put(5, "Germany"));
        table.put(5, "Japan");
        System.out.println(table.size());
        System.out.println(table.get(1));
        System.out.println(table.get(2));
        System.out.println(table.get(3));
        System.out.println(table.get(4));
        System.out.println(table.get(5));
    }
}
