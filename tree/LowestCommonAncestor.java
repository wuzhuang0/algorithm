/**
 * @Description: leetcode 235 二叉搜索树的最近公共祖先
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 *                      6
 *                    /  \
 *                  2     8
 *                 / \   / \
 *                0   4 7   9
 *                     /     \
 *                    3       5
 *
 *
 * 示例：
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出：6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.value;
        int pVal = p.value;
        int qVal = q.value;
        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.value;
        int qVal = q.value;
        // Start from the root node of the tree
        TreeNode node = root;
        // Traverse the tree
        while (node != null) {
            // Value of ancestor/parent node.
            int parentVal = node.value;
            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
