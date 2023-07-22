package BinaryTree;
public class IsSumTree {
    // Recursive Approach
    // TC: O(N^2)
    // SC: O(N)
    boolean isSumTree(Node root)
	{
        if(root == null || (root.left == null && root.right == null))
            return true;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return ((leftSum + rightSum) == root.data) && isSumTree(root.left) && isSumTree(root.right);
	}
	int sum(Node node){
	    if(node == null)
	        return 0;
	    return node.data + sum(node.left) + sum(node.right);
	}
}
