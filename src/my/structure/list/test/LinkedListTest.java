package my.structure.list.test;

import java.util.LinkedList;

/**
 * @Description TODO
 * @Author marshal
 * @Date 18/9/20 9:17 AM
 */
public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<String> items = new LinkedList<>();
        items.add("C");
        items.add("Scala");
        items.add("PHP");
        items.add("Java");
        System.out.println(items);
        items.addFirst("Python");
        System.out.println(items);
        items.addLast("C++");
        System.out.println(items);
        items.add("Go");
        System.out.println(items);
        items.remove(1);

    }
}
