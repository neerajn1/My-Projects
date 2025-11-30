public class Tree<T extends Comparable<T>> { //definition of Tree class
    private TreeNode<T> root;

    // Constructor initializes an empty Tree
    public Tree() {
        root = null;
    }

    // Insert a new node in the binary search tree
    public void insertNode(T insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue); // Create root node
        } else {
            root.insert(insertValue); // Call the insert method
        }
    }

    // Preorder traversal
    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.printf("%s ", node.data); // Getting/retrieving the root
        preorderHelper(node.leftNode);      // Traverse left subtree
        preorderHelper(node.rightNode);     // Traverse right subtree
    }

    // Postorder traversal
    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postorderHelper(node.leftNode); // Traverse left subtree
        postorderHelper(node.rightNode); // Traverse right subtree
        System.out.printf("%s ", node.data); // Getting/retrieving the root
    }

    // Search for a specific object in the tree
    public boolean search(T value) {
        return searchHelper(root, value); //returns the root when asked for value
    }

    private boolean searchHelper(TreeNode<T> node, T value) { //looking out for the node and value
        if (node == null) {
            return false;
        }
        if (node.data.equals(value)) { //using node methods
            return true;
        }
        return (value.compareTo(node.data) < 0)
                ? searchHelper(node.leftNode, value) //conditional statement for if-else statement to make code simpler
                : searchHelper(node.rightNode, value); //else is " : "
    }
}

