package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class KthAncestor {
    static void generateArray(Node root, int ancestors[])
{
    // There will be no ancestor of root node
    ancestors[root.data] = -1;
 
    // level order traversal to
    // generate 1st ancestor
    Queue<Node> q = new LinkedList<Node> ();
    q.add(root);
 
    while(!q.isEmpty())
    {
        Node temp = q.peek();
        q.remove();
 
        if (temp.left != null)
        {
            ancestors[temp.left.data] = temp.data;
            q.add(temp.left);
        }
 
        if (temp.right != null)
        {
            ancestors[temp.right.data] = temp.data;
            q.add(temp.right);
        }
    }
}
 
// function to calculate Kth ancestor
static int kthAncestor(Node root, int n, int k, int node)
{
    // create array to store 1st ancestors
    int ancestors[] = new int[n + 1];
 
    // generate first ancestor array
    generateArray(root,ancestors);
 
    // variable to track record of number of
    // ancestors visited
    int count = 0;
 
    while (node!=-1)
    {
        node = ancestors[node];
        count++;
 
        if(count==k)
            break;
    }
 
    // print Kth ancestor
    return node;
}
static boolean RootToNode(Node root, int key,
                            Vector<Integer> v)
{
    if (root == null)
        return false;
 
    // Add current node to the path
    v.add(root.data);
 
    // If current node is the target node
    if (root.data == key)
        return true;
 
    // If the target node exists in
    // the left or the right sub-tree
    if (RootToNode(root.left, key, v)
        || RootToNode(root.right, key, v))
        return true;
 
    // Remove the last inserted node as
    // it is not a part of the path
    // from root to target
    v.removeElementAt(v.size()-1);
    return false;
}
}
