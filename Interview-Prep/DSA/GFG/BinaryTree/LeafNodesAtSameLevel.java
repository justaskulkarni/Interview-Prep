package BinaryTree;

public class LeafNodesAtSameLevel {
    // TC: O(N)
    // SC: O(N)
    
    boolean check(Node root)
    {
	    int ht = height(root);
	    return helper(root, 1, ht);
    }
    int height(Node node){
        if(node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return Math.max(lheight, rheight) + 1;
    }
    boolean helper(Node node, int level, int height){
        if(node == null)
            return true;
        if(node.left == null && node.right == null){
            return level == height;
        }
        return helper(node.left, level + 1, height) && helper(node.right, level + 1, height);
    }    
}
