public class TreeNode<T extends Comparable<T>> { //class TreeNode definition
    TreeNode<T> leftNode; // Left child
    T data;               // Node value
    TreeNode<T> rightNode; // Right child

    // Constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData) {
        data = nodeData;
        leftNode = rightNode = null; // Node has no children
    }

    // Insert a new node in the tree; ignore duplicate values
    public void insert(T inputValue) {
        if (inputValue.compareTo(data) < 0) { // Inserting in the left subtree
            if (leftNode == null) {
                leftNode = new TreeNode<>(inputValue); //nodes on left are less
            } else {
                leftNode.insert(inputValue); // Recursive-ness
            }
        } else if (inputValue.compareTo(data) > 0) { // Inserting in the right subtree
            if (rightNode == null) {
                rightNode = new TreeNode<>(inputValue); //nodes on right are greater
            } else {
                rightNode.insert(inputValue); // Recursive-ness
            }
        }
        // No duplicates needed (ignore)
    }
}
