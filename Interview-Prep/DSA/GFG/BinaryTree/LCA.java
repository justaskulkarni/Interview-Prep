package BinaryTree;

import java.util.ArrayList;

public class LCA {
    // TC: O(N)
    // SC: O(N)
    Node lca(Node root, int n1,int n2)
	{
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		isPath(root, path1, n1);
		isPath(root, path2, n2);
		int i;
		for(i = 0; i < path1.size() && i < path2.size(); i++)
		    if(!path1.get(i).equals(path2.get(i)))
		        break;
		return path1.get(i - 1);
	}
	boolean isPath(Node node, ArrayList<Node> arr, int n){
	    if(node == null)
	        return false;
	    arr.add(node);
	    if(node.data == n || isPath(node.left, arr, n) || isPath(node.right, arr, n))
	        return true;
	    arr.remove(arr.size() - 1);
	    return false;
	}    
    // TC: O(N)
    // SC: O(H)
    Node lca2(Node root, int n1,int n2)
	{
		if(root == null)
		    return null;
		if(root.data == n1 || root.data == n2)
		    return root;
		Node leftlca = lca(root.left, n1, n2);
		Node rightlca = lca(root.right, n1, n2);
		if(leftlca != null && rightlca != null)
		    return root;
		return (leftlca != null) ? leftlca: rightlca;
	}
}
