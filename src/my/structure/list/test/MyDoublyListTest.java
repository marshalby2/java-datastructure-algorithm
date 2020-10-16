package my.structure.list.test;

import my.structure.list.impl.MyDoublyList;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 7:48 PM
 */
public class MyDoublyListTest {
    public static void main(String[] args) {

        var list = new MyDoublyList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("size = " + list.size());
//        System.out.println(list.getFist());
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
//        System.out.println(list.getLast());
        System.out.println("remove: " + list.remove(0));
        System.out.println(list.get(0));

    }
}
