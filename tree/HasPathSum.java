/**
 * @Description: leetcode 112  路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @Author: wz
 * @Date: 2020-09-11
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.value == sum;
        }
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }
}
