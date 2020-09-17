package my.structure.list;

import java.util.NoSuchElementException;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 10:59 AM
 */
public class MyDoublyList {

    private int size = 0;

    private Node first;
    private Node last;

    public class Node {
        private Node prev;
        private Node next;
        private int data;
        public Node() {}

        public Node(Node pre, int data, Node next) {
            this.prev = pre;
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }


    private void linkFirst(int data) {
        Node f = first;
        var newNode = new Node(null, data, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(int data) {
        Node l = last;
        var newNode = new Node(l, data, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public boolean add(int data) {
        linkLast(data);
        return true;
    }

    public int getFist() {
        Node f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.data;
    }

    public int getLast() {
        Node l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.data;
    }

    public int get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    Node node(int index) {
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                // 向后移位到index所对应节点
                x = x.next;
            }
            return x;
        } else {
            Node y = last;
            for (int i = size - 1; i > index; i--) {
                // 向前移位到index所对应节点
                y = y.prev;
            }
            return y;
        }
    }


    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }
}
