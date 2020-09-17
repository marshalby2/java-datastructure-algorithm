package my.structure.stack;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 9:47 PM
 */
public class ListStackTest {
    public static void main(String[] args) {
        ListStack stack = new ListStack();
        stack.push(10);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
    }
}
