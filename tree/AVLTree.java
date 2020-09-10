/**
 * 平衡二叉树
 */
public class AVLTree {

    // 自上而下
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

     private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

     // ---------------------------------------------------------------------------

    // 自下而上
    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 1
     * 2  3
     * 4    6
     * 5      7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        boolean ans = new AVLTree().isBalanced2(root);
        System.out.println(ans);
    }
}
