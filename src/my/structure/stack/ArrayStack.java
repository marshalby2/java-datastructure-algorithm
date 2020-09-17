package my.structure.stack;

/**
 * @Description 基于数组实现的顺序栈
 * @Author marshal
 * @Date 17/9/20 8:46 PM
 */
public class ArrayStack {

    private String[] items; // 数组
    private int count;      // 栈中元素的个数
    private int n;          // 栈的大小

    // 初始化
    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    // 入栈操作
    public boolean push(String item) {
        // 当元素个数等于数组长度时,入栈失败
        if (count == n) return false;
        items[count] = item;
        ++count;
        return true;
    }

    // 出栈操作
    public String pop() {
        if (count == 0) {
            return null;
        }
        String result = items[count - 1];
        --count;
        return result;
    }

}
