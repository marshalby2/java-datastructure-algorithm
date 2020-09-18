package my.structure.list;

import java.util.NoSuchElementException;

/**
 * @Description 模仿LinkedList 写一个双向链表
 * @Author marshal
 * @Date 17/9/20 10:59 AM
 */
public class MyDoublyList {

    private int size = 0;

    // 记录第一个节点的地址
    private Node first;
    // 记录最后一个节点的地址
    private Node last;

    public class Node {
        private Node prev;
        private Node next;
        private int data;

        public Node() {
        }

        public Node(Node pre, int data, Node next) {
            this.prev = pre;
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }
    }


    /**
     * 在链表头部加入新节点,具体步骤
     * 1. 新建一个节点对象,{prev: null, data: data, next: first},将旧的first指针赋值给新节点的next指针
     * 2. first指针指向新建的节点地址
     * 3. 如果是第一次添加,则last指针也要指向新建的节点地址
     * 4. 如果不是第一次添加,则将当前链表的第二个节点(即新节点的next指针指向的节点)的prev指针,指向新节点的地址
     *
     *
     * @param data
     */
    private void linkFirst(int data) {
        Node f = first;
        var newNode = new Node(null, data, f);
        first = newNode;
        if (f == null) {
            // 第一次添加,首节点数据为 {prev: null, data: data, next: null}
            //同时将首节点的地址赋值给last指针
            last = newNode;
        } else {
            // 假设是第二次添加,此时节点数据为 {prev: null, data: data, next: 上一个节点的地址}
            // 同时将该节点的地址赋值给上一个节点的prev指针
            f.prev = newNode;
        }
        size++;
    }

    private void linkLast(int data) {
        Node l = last;
        var newNode = new Node(l, data, null);
        last = newNode;
        if (l == null) {
            // 第一个节点,此时该节点数据为{prev:null, data: data, next: null}
            // 同时将第一个节点的地址赋值给first指针
            first = newNode;
        } else {
            // 假设是第二次添加节点,该节点数据为 {prev: 上一个节点的地址, data: data, next: null}
            // 同时将新节点的地址赋给上一个节点的next指针
            l.next = newNode;
        }
        size++;
    }

    public boolean add(int data) {
        linkLast(data);
        return true;
    }

    public boolean addFirst(int data) {
        linkFirst(data);
        return true;
    }

    public boolean addLast(int data) {
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

    public int remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    public int unlink(Node node) {

        int data = node.data;
        Node prev = node.prev;
        Node next = node.next;

        // 切断当前节点和前一个节点的联系
        if (prev == null) {
            // 此时node是首节点
            // 将first指针指向node节点的next指针指向的节点(即第二个节点),从而达到删除该节点的效果
            first = next;
        } else {
            // 不是首节点
            // 将上一个节点的next指针指向当前节点的下一个节点,从未删除当前节点
            prev.next = next;
            // 放弃持有对上一个节点引用,也许是为了让GC清理该节点对象
            node.prev = null;
        }

        // 切断当前节点和后一个节点的联系
        if (next == null) {
            // 此时node是尾节点
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }
        // 如果node存的是对象,需要设为空值
        // node.data = null;
        size--;
        return data;
    }


    /**
     *  根据下标查找节点
     *
     * @param index
     * @return
     */
    Node node(int index) {
        // 在链表的前半部分找
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                // 向后移位到index所对应节点
                x = x.next;
            }
            return x;
        } else {
            // 在链表的后半部分找
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
