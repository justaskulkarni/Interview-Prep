package BinaryTree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorder {
     static Node buildUtil(int in[], int post[], int inStrt,
                          int inEnd)
    {
 
        // Base case
        if (inStrt > inEnd)
            return null;
 
        /* Pick current node from Postorder traversal
        using postIndex and decrement postIndex */
        int curr = post[index];
        Node node = newNode(curr);
        (index)--;
 
        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;
 
        /* Else find the index of this node in Inorder
        traversal */
        int iIndex = mp.get(curr);
 
        /* Using index in Inorder traversal, con
        left and right subtrees */
        node.right = buildUtil(in, post, iIndex + 1, inEnd);
        node.left = buildUtil(in, post, inStrt, iIndex - 1);
        return node;
    }
    static HashMap<Integer, Integer> mp
        = new HashMap<Integer, Integer>();
    static int index;
 
    // This function mainly creates an unordered_map, then
    // calls buildTreeUtil()
    static Node buildTree(int in[], int post[], int len)
    {
 
        // Store indexes of all items so that we
        // we can quickly find later
        for (int i = 0; i < len; i++)
            mp.put(in[i], i);
 
        index = len - 1; // Index in postorder
        return buildUtil(in, post, 0, len - 1);
    }
    static Node newNode(int data)
    {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }
 
}
