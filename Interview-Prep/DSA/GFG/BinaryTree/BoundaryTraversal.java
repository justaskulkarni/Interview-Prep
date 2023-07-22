package BinaryTree;

import java.util.ArrayList;

public class BoundaryTraversal {
    ArrayList<Integer> arr;
	ArrayList <Integer> boundary(Node node)
	{
	    arr = new ArrayList<>();
	    printBoundary(node);
	    return arr;
	}
	void printBoundary(Node node){
	    if(node == null)
	        return ;
	    arr.add(node.data);
	    printBoundaryLeft(node.left);
	    printLeaves(node.left);
	    printLeaves(node.right);
	    printBoundaryRight(node.right);
	}
	void printBoundaryLeft(Node node){
	    if(node == null)
	        return ;
	    if(node.left != null){
	        arr.add(node.data);
	        printBoundaryLeft(node.left);
	    }
	    else if(node.right != null){
	        arr.add(node.data);
	        printBoundaryLeft(node.right);
	    }
	}
	void printBoundaryRight(Node node){
	    if(node == null)
	        return ;
	    if(node.right != null){
	        printBoundaryRight(node.right);
	        arr.add(node.data);
	    }
	    else if(node.left != null){
	        printBoundaryRight(node.left);
	        arr.add(node.data);
	    }
	}
	void printLeaves(Node node){
	    if(node == null)
	        return ;
	    printLeaves(node.left);
	    if(node.left == null && node.right == null)
	        arr.add(node.data);
	    printLeaves(node.right);
	}
}
