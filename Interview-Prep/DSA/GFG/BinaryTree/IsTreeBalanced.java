package BinaryTree;
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class IsTreeBalanced{
    
        boolean isBalanced(Node root)
    {
    	if(root == null)   
    	    return true;
    	int lheight = height(root.left);
    	int rheight = height(root.right);
    	if(Math.abs(lheight - rheight) > 1)
    	    return false;
    	return isBalanced(root.left) && isBalanced(root.right);
    	
    }
    int height(Node node){
        if(node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return Math.max(lheight, rheight) + 1;
    }
    
}