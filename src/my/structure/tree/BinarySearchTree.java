package my.structure.tree;

/**
 * @Description TODO
 * @Author marshal
 * @Date 14/10/20 8:04 PM
 * <p>
 * 二叉查找树
 * <p>
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 * </p>
 * 动画演示地址 <a>https://www.cs.usfca.edu/~galles/visualization/BST.html</a>
 */
public class BinarySearchTree {

    private Node tree;

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 首先，我们看如何在二叉查找树中查找一个节点。我们先取根节点，
     * 如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；
     * 如果要查找的数据比根节点的值大，那就在右子树中递归查找。
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }


    /**
     * 新插入的数据一般都是在叶子节点上，所以我们只需要从根节点开始，依次比较要插入的数据和节点的大小关系。
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；如果不为空，就再递归遍历右子树，查找插入位置。
     * 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；如果不为空，就再递归遍历左子树，查找插入位置。
     *
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data >= p.data) { // 插入右边
                if (p.right == null) { // 右节点为空
                    p.right = new Node(data);
                } else {
                    // 移动节点
                    p = p.right;
                }
            } else { // 插入左边
                if (p.left == null) { // 左节点为空
                    p.left = new Node(data);
                } else {
                    // 移动节点
                    p = p.left;
                }
            }
        }
    }


    /**
     * 删除节点
     * <p>
     * 分三种情况
     * 1. 如果要删除的节点没有子节点，则直接将该节点的父节点指向该节点的指针设为null即可
     * 2. 如果要删除的节点有一个子节点（左节点或者右节点），则将该节点的父节点指向该节点的指针指向该节点的子节点即可
     * 3. 如果要删除的节点有两个子节点，则有两种删除方式
     * 3.1 找到该节点右子树中的最小节点，替换到该节点
     * 3.2 找到该节点左子树中的最大节点，替换到该节点（我自己观察总结的）
     *
     * @param data
     */
    public void delete(int data) {
        Node p = tree; // 待删除的节点
        Node pp = null; // 父节点
        while (p != null && data != p.data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }

        if (p == null) return; // 未找到节点

        // 要删除的节点p有两个子节点的情况
        if (p.right != null && p.left != null) {
            // 查找右子树中的最小节点
            Node minP = p.right;
            Node minPP = p; // minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP中的数据替换到p中
            p = minP;
            pp = minPP;
        }

        // p节点只有一个子节点或者没有子节点的情况
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // p是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    /**
     *  查找最大节点
     *
     * @return
     */
    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     *  查找最小节点
     *
     * @return
     */
    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }


}
