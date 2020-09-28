/**
 * @Description:  leetcode 450 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点引用
 *
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}
