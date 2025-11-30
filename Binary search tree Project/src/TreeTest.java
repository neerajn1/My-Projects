// Name: Neeraj N
//This project used recursive insertion with preorder/postorder traversal methods using .compareTo method as well
//Also searches for a node in the tree, where it returns true/false if anything is found
//Has all Dessert Objects that are inherited from the Dessert class
public class TreeTest {
    public static void main(String[] args) {
        Tree<Dessert> dessertTreeTest = new Tree<>();

        // Populate the tree with 5 new Dessert objects
        dessertTreeTest.insertNode(new Dessert("Chocolate Ice Cream", 143, 8));
        dessertTreeTest.insertNode(new Dessert("Salted Caramel Brownie", 580, 6));
        dessertTreeTest.insertNode(new Dessert("Vanilla Cupcake", 230, 4));
        dessertTreeTest.insertNode(new Dessert("Pumpkin Bite", 250, 6));
        dessertTreeTest.insertNode(new Dessert("Glazed Donut", 180, 5));

        // Preorder Traversal
        System.out.println("Preorder Traversal:");
        dessertTreeTest.preorderTraversal();

        // Postorder Traversal
        System.out.println("\n\nPostorder Traversal:"); //two "\n" for better formatting
        dessertTreeTest.postorderTraversal();

        // Search for a specific Dessert
        Dessert lookOutDessert = new Dessert("Pumpkin Donut", 230, 5);
        System.out.println("\n\nLooking out for: " + lookOutDessert);
        System.out.println("I've got: " + dessertTreeTest.search(lookOutDessert));
    }
}

