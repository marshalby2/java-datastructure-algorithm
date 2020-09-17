package my.structure.stack;

/**
 * @Description 基于链表实现的链式栈
 * @Author marshal
 * @Date 17/9/20 9:30 PM
 */
public class ListStack {

    // 头
    private Node head = new Node();

    private int size;

    private class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }


    // 入栈
    public boolean push(int data) {
        Node newNode = new Node(data);
        Node h = head;
        while (h.next != null) {
            h = h.next;
        }
        h.next = newNode;
        ++size;
        return true;
    }

    // 出栈
    public int pop() {
        // 拿到最后一个节点数据,并返回
        Node h = head;
        // 找到倒数第二个节点,把它的下一个节点的数据返回,同时删除这个节点
        for (int i = 0; i < size - 1; i++) {
            h = h.next;
        }
        int result = h.next.data;
        h.next = null;
        --size;
        return result;
    }

    public int size() {
        return size;
    }
}
