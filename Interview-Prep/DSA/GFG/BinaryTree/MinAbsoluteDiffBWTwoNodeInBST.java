package BinaryTree;

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

public class MinAbsoluteDiffBWTwoNodeInBST {
    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return ans;
    }
    public void inOrder(TreeNode node){
        if(node.left != null)
            inOrder(node.left);
        ans = Math.min(ans, Math.abs(node.val - prev));
        prev = node.val;
        if(node.right != null)
            inOrder(node.right);
    }
}
