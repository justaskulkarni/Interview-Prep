package BST;
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class SearchNode {
    // TC: O(H)
    // SC: O(H)
    boolean search(Node root, int x) {
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        if(root.data < x)
            return search(root.right, x);
        return search(root.left, x);
    }
}
