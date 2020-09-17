package my.structure.list;

/**
 * @Description TODO
 * @Author marshal
 * @Date 16/9/20 10:28 PM
 */
public class MySingleListTest {
    public static void main(String[] args) {
        MySingleList list = new MySingleList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.print();
        System.out.println("===========reverse============");
//        list.reverseList(list.reverse());
        list.removeByIndex(1);
        System.out.println(list.size());
        list.print();

    }
}

