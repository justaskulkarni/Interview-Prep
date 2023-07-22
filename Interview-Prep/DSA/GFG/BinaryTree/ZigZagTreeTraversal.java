package BinaryTree;
import java.util.ArrayList;
public class ZigZagTreeTraversal {
	class Node
	{
		int data;
		Node left,right;
		Node(int d)
		{
			data=d;
			left=right=null;
		}
	}
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> arr = new ArrayList<>();
	    int ht = height(root);
	    boolean lor = true;
	    for(int i = 1; i <= ht; i++){
	        helper(root, i, arr, lor);
	        lor = !lor;
	    }
	    return arr;
	}
	
	void helper(Node node, int height, ArrayList<Integer> arr, boolean lor){
	    
	    if(node == null)
	        return;
	    if(height <= 1){
	        arr.add(node.data);
	        return;
	    }
	    if(lor){
	        if(node.left != null)
	            helper(node.left, height - 1, arr, lor);
	        if(node.right != null)
	            helper(node.right, height - 1, arr, lor);
	    }
	    else{
	        if(node.right != null)
	            helper(node.right, height - 1, arr, lor);
	        if(node.left != null)
	            helper(node.left, height - 1, arr, lor);
	    }
	}
	int height(Node node){
	    if(node == null)
	        return 0;
	    int lheight = height(node.left);
	    int rheight = height(node.right);
	    return Math.max(lheight, rheight) + 1;
	}
}
