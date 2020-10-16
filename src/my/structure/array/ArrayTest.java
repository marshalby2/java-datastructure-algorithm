package my.structure.array;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author marshal
 * @Date 12/10/20 3:14 PM
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] a  = {1, 2, 3, 4, 5};
//        int[] b = new int[10];
//        int[] c = new int[10];
//        int[] d = new int[10];
        // 数组的拷贝操作
//        System.arraycopy(a, 0, b, 0, a.length);
//        System.arraycopy(a, 2, c, 0, 3);
//        System.arraycopy(a, 2, d, 2, 3);
//        System.out.println(Arrays.toString(a)); // [1, 2, 3, 4, 5]
//        System.out.println(Arrays.toString(b)); // [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
//        System.out.println(Arrays.toString(c)); // [3, 4, 5, 0, 0, 0, 0, 0, 0, 0]
//        System.out.println(Arrays.toString(d)); // [0, 0, 3, 4, 5, 0, 0, 0, 0, 0]

//        var ints = Arrays.copyOf(a, 10);
//        System.out.println(Arrays.toString(ints)); // [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
        // 删除下标0处的数据
        int i = 1;
        System.arraycopy(a, i + 1, a, i, a.length - 1 - i);
        a[a.length - 1] = 0;
        System.out.println(a.length);
        System.out.println(Arrays.toString(a)); // [1, 3, 4, 5, 0]

    }
}
