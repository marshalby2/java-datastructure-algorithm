package my.structure.list;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 10:59 AM
 */
public class MyDoublyList {

    public Node head = new Node();

    private int size = 0;

    public class Node {
        private Node pre;
        private Node next;
        private int data;
        public Node() {}

        public Node(Node pre, Node next, int data) {
            this.pre = pre;
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
        }
    }


    public void add(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.pre = temp;
        temp.next = newNode;
    }


    public int size() {
        return size;
    }
}
