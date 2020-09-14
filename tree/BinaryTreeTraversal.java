import java.util.*;

/**
 * 二叉树遍历
 *              1
 *           2     3
 *          4 5   6 7
 */

public class BinaryTreeTraversal {

    //--------------------------------递归遍历--------------

    /**
     * 前序遍历 1 2 4 5 3 6 7
     * 先访问根节点——左子树——右子树
     */
    private List<TreeNode> list = new ArrayList<>();

    public void preOrder(TreeNode root) {
        list.add(root);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历 4 2 5 1 6 3 7
     * 先访问左子树——根节点——右子树
     */
    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root);
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * 先访问左子树-右子树-根节点
     */
    public void postOrder(TreeNode root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        list.add(root);
    }

    //--------------------------------迭代遍历--------------

    // 前序遍历
    public void preOrderIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    // 中序遍历
    public void inOrderIterate(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (!stack.isEmpty() || node!=null){
            while (node != null){
                stack.add(node);
                node=node.left;
            }
            if (!stack.isEmpty()){
                node= stack.pop();
                System.out.println(node.value);
                node=node.right;
            }
        }
    }

    // 后序遍历
    public void postOrderIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 记录已访问的结点
        Set<TreeNode> visited = new HashSet<>();
        stack.add(root);
        visited.add(root);
        while (!stack.isEmpty()) {
            root = getUnVisitedNode(stack.peek(), visited);
            if (root == null) {
                System.out.println(stack.pop().value);
            } else {
                stack.add(root);
                visited.add(root);
            }
        }
    }
    private static TreeNode getUnVisitedNode(TreeNode node, Set<TreeNode> visited) {
        if (node.left != null && !visited.contains(node.left)) {
            return node.left;
        } else if (node.right != null && !visited.contains(node.right)) {
            return node.right;
        }
        else {
            return null;
        }
    }

    //-------------------------- morris算法 -----------------------------

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        new BinaryTreeTraversal().inOrderIterate(root);
    }
}
