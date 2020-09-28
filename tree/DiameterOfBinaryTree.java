/**
 * @Description: leetcode 543 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *              1
 *             / \
 *            2    3
 *           / \
 *          4   5
 *         /   / \
 *        9   7   6
 *           /
 *          8
 *  而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
 *  路径 [9, 4, 2, 5, 7, 8] 可以被看作以 2 为起点，从其左儿子向下遍历的路径 [2, 4, 9] 和从其右儿子向下遍历的路径 [2, 5, 7, 8] 拼接得到。
 *  假设我们知道对于该节点的左儿子向下遍历经过最多的节点数 L （即以左儿子为根的子树的深度）
 *  和其右儿子向下遍历经过最多的节点数 R （即以右儿子为根的子树的深度），那么以该节点为起点的路径经过节点数的最大值即为 L+R+1
 *  我们定义一个递归函数 depth(node) 计算Dnode
 *  函数返回该节点为根的子树的深度。先递归调用左儿子和右儿子求得它们为根的子树的深度 L 和 R ，则该节点为根的子树的深度即为
 *   max(L,R)+1 ，该节点的Dnode值为 L+R+1   边数为L+R  节点数-1
 */
public class DiameterOfBinaryTree {
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        // 不断更新边数和
        ans = Math.max(ans, leftDepth + rightDepth);
        // 返回节点深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
