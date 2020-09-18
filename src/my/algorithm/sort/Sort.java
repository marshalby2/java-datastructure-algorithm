package my.algorithm.sort;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author marshal
 * @Date 18/9/20 11:17 AM
 */
public class Sort {

    /**
     * 冒泡排序
     * <p>
     * <p>
     * 原理:
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
     * 这步做完后，最后的元素会是最大的数。针对所有的元素重复以上的步骤，除了最后一个。
     * </p>
     * <p>
     * 复杂度:
     * 最好: O(n)
     * 平均: O(n²)
     * </p>
     *
     * @param array
     */
    public static int[] bubbleSort(int[] array) {
        var n = array.length;
        if (n <= 0) {
            throw new RuntimeException("array length illegal");
        }
        for (int i = 0; i < n; i++) {
            // 是否退出循环,当没有发生比较的时候,数组就已经排好序了,就退出外层循环
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println("第 " + i + " 次比较: " + Arrays.toString(array));
            if (!flag) {
                break;
            }
        }
        return array;
    }


    /**
     * 插入排序
     * <p>
     * 原理:
     * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     * <p>
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        var n = array.length;
        if (n <= 0) {
            throw new RuntimeException("array length illegal");
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("第 " + i + " 次比较: " + Arrays.toString(array));
        }
        return array;
    }

    /**
     * 选择排序
     * <p>
     * 原理:
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * </p>
     * <p>
     * 复杂度:
     *
     * </p>
     *
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array) {
        var n = array.length;
        if (n <= 0) {
            throw new RuntimeException("array length illegal");
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // 找到最小值下标
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换值
            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            System.out.println("第 " + i + " 次比较: " + Arrays.toString(array));
        }
        return array;
    }

    public static int[] model(int[] array) {
        var n = array.length;
        if (n <= 0) {
            throw new RuntimeException("array length illegal");
        }
        for (int i = 0; i < n; i++) {

        }
        return array;
    }
}
