package my.structure.list;

/**
 * @Description TODO
 * @Author marshal
 * @Date 16/9/20 10:28 PM
 */
public class MySinglyListTest {
    public static void main(String[] args) {
        MySinglyList list = new MySinglyList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.print();
        System.out.println("===========reverse============");
//        System.out.println(list.reverse());
        list.printReverseList(list.reverse());
//        list.removeByIndex(1);
//        System.out.println(list.size());
//        list.print();

    }
}

