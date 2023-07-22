package DSA.Leetcode.Daily;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class MaximumLevelSum {
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;
            int i = 0;
            for(; i < n; i++){
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            if(sum > maxSum){
                maxLevel = level;
                maxSum = sum;
            }
            level++;
        }  
        return maxLevel;  
    }
}
