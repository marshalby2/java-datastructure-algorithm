package my.structure.list;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 11:02 AM
 */
public class CircularTest {
    public static void main(String[] args) {
        MyCircleList list = new MyCircleList();
        list.add(111);
//        list.add(3);
//        list.add(5);
//        list.print();
        System.out.println("========get========");
        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));

        System.out.println("========size========");
        System.out.println(list.size());
        System.out.println("========print========");
        list.print();
        System.out.println("========remove========");
        System.out.println(list.removeByIndex(0));
        System.out.println(list.size());
    }
}
