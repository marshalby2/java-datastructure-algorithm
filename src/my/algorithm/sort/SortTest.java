package my.algorithm.sort;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author marshal
 * @Date 18/9/20 11:26 AM
 */
public class SortTest {
    public static void main(String[] args) {
        int[] nums = {9, 2, 5, 3, 8, 7, 1, 4, 0, 6};
//        System.out.println(nums);
//        System.out.println( "排序结果 :" + Arrays.toString(Sort.bubbleSort(nums)));
//        System.out.println( "排序结果 :" + Arrays.toString(Sort.insertionSort(new int[] {5 ,4 ,3 ,2, 1})));
//        System.out.println( "排序结果 :" + Arrays.toString(Sort.selectSort(nums)));
        System.out.println( "排序结果 :" + Arrays.toString(Sort.mereSort(nums)));
    }
}
