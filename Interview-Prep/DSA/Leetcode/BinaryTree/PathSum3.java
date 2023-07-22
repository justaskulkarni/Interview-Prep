package DSA.Leetcode.BinaryTree;

public class PathSum3 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return count;
        helper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }
    public void helper(TreeNode root, int targetSum, long curSum){
        if(root == null)
            return ;
        curSum  += root.val;
        if(curSum == (long)targetSum)
            count++;
        helper(root.left, targetSum, curSum);
        helper(root.right, targetSum, curSum);
    }    
}
