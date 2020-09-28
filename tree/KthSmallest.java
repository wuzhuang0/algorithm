import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: leetcode 230
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素
 * 进阶：  如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */
public class KthSmallest {
    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k-1);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.value);
        inOrder(root.right);
    }

    // 迭代方式中序遍历
    public void inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.value);
                root = root.right;
            }
        }
    }
}
