package my.structure.queue;

import my.structure.stack.ArrayStack;

/**
 * @Description TODO
 * @Author marshal
 * @Date 17/9/20 9:17 PM
 */
public class ArrayQueue {

    // items 数组, n 数组长度
    private String[] items;
    private int n = 0;
    // head 表示队头下标,tail表示队尾下标
    private int head = 0;
    private int tail = 0;


    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     *  入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) return false;
        items[tail]=item;
        ++tail;
        return true;
    }


    /**
     *  出队
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) return null;
        String result = items[head];
        ++head;
        return result;
    }
}
