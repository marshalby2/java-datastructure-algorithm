package my.structure.list.test;

import my.structure.list.impl.MyArrayList;

/**
 * @Description TODO
 * @Author marshal
 * @Date 16/10/20 3:56 PM
 */
public class MyArrayListTest {

    public static void main(String[] args) {
        var list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list.get(2));
        System.out.println(list.size());
    }

}
