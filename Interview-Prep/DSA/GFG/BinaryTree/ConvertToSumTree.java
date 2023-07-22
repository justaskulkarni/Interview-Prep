package BinaryTree;

public class ConvertToSumTree {
    public void toSumTree(Node root){
        helper(root);
    }
    public int helper(Node node){
        if(node == null)
            return 0;
        int old_value = node.data;
        node.data = helper(node.left) + helper(node.right);
        return node.data + old_value; 
    }
}
