package my.structure.list.impl;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Description TODO
 * @Author marshal
 * @Date 16/10/20 11:45 AM
 */
public class MyArrayList {

    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    private static final int[] EMPTY_ELEMENTDATA = {};

    private int[] elementData;

    private int size;

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elementData = new int[capacity];
        } else if (capacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public MyArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *  每次增加5
     *
     * @return
     */
    private int[] grow() {
        if (elementData.length > 0) {
            elementData = Arrays.copyOf(elementData, elementData.length + 5);
        } else {
            elementData = new int[DEFAULT_CAPACITY];
        }
        return elementData;
    }

    private void add(int e, int[] elementData, int s) {
        if (s == elementData.length) {
            elementData = grow();
        }
        elementData[s] = e;
        size = s + 1;
    }


    public boolean add(int e) {
        add(e, elementData, size);
        return true;
    }

    public int get(int index) {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

    public int remove(int index) {
        Objects.checkIndex(index, size);
        final int[] es = elementData;
        int oldValue = es[index];
        fastRemove(es, index);
        return oldValue;
    }

    /**
     * 删除指定下标处的元素，同时将元素左移，将后面空出来的位置上的元素设为0
     *
     * @param es
     * @param i
     */
    private void fastRemove(int[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }
        es[size = newSize] = 0;
    }

}
