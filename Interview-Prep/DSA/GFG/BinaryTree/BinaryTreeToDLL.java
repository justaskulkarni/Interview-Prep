package BinaryTree;

public class BinaryTreeToDLL {
    // TC: O(N)
    // SC: O(N)
    Node prev = null, head = null;
    class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
    Node bToDLL(Node root)
    {
	    if(root == null)
	        return null;
	    bToDLL(root.left);
	    if(prev == null)
	        head = root;
	    else{
	        root.left = prev;
	        prev.right = root;
	    }
	    prev = root;
	    bToDLL(root.right);
	    return head;
    }
    // Space Optimized
    Node bToDLLSpaceOptimized(Node root)
    {
	    if(root == null)
	        return null;
	    root = helper(root);
	    while(root.left != null)
	        root = root.left;
	    return root;
    }
    Node helper(Node node){
        if(node == null)
            return null;
        if(node.left != null){
            Node left = helper(node.left);
            for(; left.right != null; left = left.right);
            left.right = node;
            node.left = left;
        }
        if(node.right != null){
            Node right = helper(node.right);
            for(; right.left != null; right = right.left);
            right.left = node;
            node.right = right;
        }
        return node;
    }
}
