package DSA.Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    public void helper(TreeNode root, int targetSum, ArrayList<Integer> list, List<List<Integer>> res){
        if(root == null)
            return ;
        list.add(root.val);
        if(root.right == null && root.left == null){
            if(targetSum == root.val){
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return ;
            }
        }
        helper(root.left, targetSum - root.val, list, res);
        helper(root.right, targetSum - root.val, list, res);
        list.remove(list.size() - 1);
    }    
}
