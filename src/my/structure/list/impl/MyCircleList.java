package my.structure.list.impl;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 11:00 AM
 */
public class MyCircleList {

    // 头结点
    public Node head = new Node();

    private int size = 0;

    private class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node node = new Node(data);
        // 第一次添加元素
        if (head.next == null) {
            node.next = head;
            head.next = node;
        } else {
            // 拿到第一个元素
            Node temp = head.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            node.next = head;
            temp.next = node;
        }
        size++;
    }

    /**
     *  根据下标获取值
     *
     * @param i
     * @return
     */
    public int get(int i) {
        checkIndex(i);
        Node temp = head.next;
        int result = -1;
        int k = 0;
        while (temp != head) {
            if (k == i) {
                result = temp.data;
                break;
            }
            k++;
            // 向后移动
            temp = temp.next;
        }
        return result;
    }

    /**
     *  根据下标删除
     *
     * @param i
     * @return
     */
    public boolean removeByIndex(int i) {
        checkIndex(i);
        Node temp = head;
        int k = 0;
        while (temp.next != head) {
            if (k == i) {
                temp.next = temp.next.next;
                size --;
                return true;
            }
            k++;
            // 向后移动
            temp = temp.next;
        }
        return false;
    }



    public void print() {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head.next;
        while (temp != head) {
            System.out.println(temp.data);
            temp = temp.next;
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
