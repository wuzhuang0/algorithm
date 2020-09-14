import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 783
 * @Description: 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * @Author: wz
 * @Date: 2020-09-11
 */
public class MinDiffInBST {
    private List<Integer> list;
    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        Collections.sort(list);
        int ans = 0;
        for (int i=0; i<list.size(); i++) {
            ans = Math.min(ans, list.get(i + 1) - list.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 采用中序遍历
     * @param root
     * @return
     */
    Integer prev, ans;
    public int minDiffInBST2(TreeNode root) {
        prev = null;
        ans = 0;
        dfs2(root);
        return ans;
    }

    private void dfs2(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root.left);
        if (prev != null) {
            ans = Math.min(ans, root.value - prev);
        }
        prev = root.value;
        dfs2(root.right);
    }
}
