package BinaryTree;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
    int maxLevel = 0;
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        helper(node, arr, 1);
        return arr;
    }
    void helper(Node node, ArrayList<Integer> arr, int level){
        if(node == null)
            return ;
        if(level > maxLevel){
            arr.add(node.data);
            maxLevel = level;
        }
        helper(node.right, arr, level + 1);
        helper(node.left, arr, level + 1);
    }
}
