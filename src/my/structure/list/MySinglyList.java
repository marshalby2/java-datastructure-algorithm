package my.structure.list;

/**
 * @Description TODO
 * @Author marshal
 * @Date 16/9/20 10:14 PM
 */
public class MySinglyList {

    private int size = 0;

    // 哨兵(带头链表)
    public Node head = new Node();

    /**
     * 节点对象
     */
    private class Node {
        public int data;
        public Node next;

        public Node() {}
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 添加一个节点
     *
     * @param data
     */
    public void add(int data) {
        // 新增一个节点
        Node newNode = new Node(data);
        Node temp = head;
        // 找到尾节点
        while (temp.next != null) {
            // 指向下一个节点
            temp = temp.next;
        }
        // 将新节点加到尾节点后
        temp.next = newNode;
        size++;
    }


    /**
     * 通过下标来获取节点
     *
     * @param i
     * @return
     */
    public int get(int i) {
        checkIndex(i);

        Node temp = head;
        int k = 0;
        int result = 0;
        while (temp.next != null) {
            if (k == i) {
                result = temp.next.data;
                break;
            }
            k++;
            temp = temp.next;
        }
        return result;
    }

    /**
     * 删除指定下标的元素
     *
     * @param i
     * @return
     */
    public boolean removeByIndex(int i) {
        checkIndex(i);

        Node temp = head;
        int k = 0;
        while (temp.next != null) {
            if (k == i) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            k++;
            temp = temp.next;
        }
        return false;
    }

    /**
     * 删除指定值的节点
     *
     * @param data
     * @return
     */
    public boolean removeByValue(int data) {
        // 遍历list,找到值与data相等的节点并删除
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                // 删除当前节点
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 打印节点
     */
    public void print() {
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     *  反转链表,返回反转后的头指针
     *
     * @return
     */
    public Node reverse() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node pre = head;
        Node current = head.next;
        Node temp = null;

        while (current != null) {
            temp = current.next;
            current.next = pre; // 反转
            pre = current;  // 指向当前节点
            current = temp; // 指向后一个节点
        }
        head.next = null;
        return pre;
    }

    public void reverseList(Node node) {
        Node temp = node;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    private void checkIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

}
