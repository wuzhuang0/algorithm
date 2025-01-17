/**
 * BST   二叉搜索树
 * 二叉查找树
 * 特性：
 * 1.左子树上所有结点的值均小于或等于它的根结点的值。
 *
 * 2.右子树上所有结点的值均大于或等于它的根结点的值。
 *
 * 3.左、右子树也分别为二叉查找树。
 *
 */
public class AbstractBinarySearchTree {

    public static class Node {
        private Integer value;
        private Node parent;
        private Node left;
        private Node right;
        private Node(Integer value, Node parent, Node left, Node right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    //根节点
    private Node root;

    //树节点数目
    protected int size;
    protected Node createNode(int value, Node parent, Node left, Node right) {
        return new Node(value, parent, left, right);
    }

    public Node search(int element) {
        Node node = root;
        while (node != null && node.value != null && node.value != element) {
            if (element < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public Node insert(int element) {
        if (root == null) {
            root = createNode(element, null, null, null);
            size++;
            return root;
        }
        Node insertParentNode = null;
        Node searchTempNode = root;
        while (searchTempNode != null && searchTempNode.value != null) {
            insertParentNode = searchTempNode;
            if (element < searchTempNode.value) {
                searchTempNode = searchTempNode.left;
            } else {
                searchTempNode = searchTempNode.right;
            }
        }
        Node newNode = createNode(element, insertParentNode, null, null);
        if (insertParentNode.value > newNode.value) {
            insertParentNode.left = newNode;
        } else {
            insertParentNode.right = newNode;
        }
        size++;
        return newNode;
    }

    public Node delete(int element) {
        Node deleteNode = search(element);
        if (deleteNode != null) {
            return delete(deleteNode);
        } else {
            return null;
        }
    }

    protected Node delete(Node deleteNode) {
        if (deleteNode != null) {
            Node nodeToReturn = null;
            if (deleteNode.left == null) {
                transplant(deleteNode, deleteNode.right);
            } else if (deleteNode.right == null) {
                transplant(deleteNode, deleteNode.left);
            } else {
                Node successorNode = getMinimum(deleteNode.right);
                    if (successorNode.parent != deleteNode) {
                        transplant(successorNode, successorNode.right);
                        successorNode.right = deleteNode.right;
                        successorNode.right.parent = successorNode;
                    }
                    transplant(deleteNode, successorNode);
                    successorNode.left = deleteNode.left;
                    successorNode.left.parent = successorNode;
                    nodeToReturn = successorNode;
                }
            }
        return null;
    }

    protected Node getMaximum(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    protected Node getMinimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    //树节点替换    nodeToReplace替换为newNode
    private Node transplant(Node nodeToReplace, Node newNode) {
        if (nodeToReplace.parent == null) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        return null;
    }

}
