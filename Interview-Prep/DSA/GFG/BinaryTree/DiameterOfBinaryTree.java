package BinaryTree;
public class DiameterOfBinaryTree {
    
    class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    // Bruteforce Approach
    // Diameter of tree may or may not be a path that has root node
    //                 (diam1)  (diam2 & diam3)
    // TC: O(N^2), since height() takes O(N) time and diam1 makes two calls to height()  
    
    int height(Node node) {
        if (node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return Math.max(lheight, rheight) + 1;
    }

    int diameter(Node node) {
        if (node == null)
            return 0;
        int diam1 = height(node.left) + height(node.right) + 1;
        int diam2 = diameter(node.left);
        int diam3 = diameter(node.right);
        return Math.max(diam1, Math.max(diam2, diam3));
    }
}
