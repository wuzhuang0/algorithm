/**
 * @Description: leetcode 222 完全二叉树的节点个数
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 示例：
 * 输入：
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * 输出： 6
 */
public class CountNodes {
    /**
     * 暴力递归
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        return root != null ? countNodes1(root.left) + countNodes1(root.right) + 1: 0;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countNodes2(root.left);
        int r = countNodes2(root.right);
        return l + r + 1;
    }


    // 求叶子节点
    public int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaf(root.left) + countLeaf(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int res = new CountNodes().countLeaf(root);
        System.out.println(res);
    }
}
