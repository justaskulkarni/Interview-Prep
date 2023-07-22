package BinaryTree;

public class MaximumSubtreeSum {
    public static long ans = 0;
    public static long preorderTraversal(BinaryTreeNode < Integer > node) {
        if (node == null) {
            return 0;
        }
        long currentSubtreeSum = (long) node.data + preorderTraversal(node.left) + preorderTraversal(node.right);
        ans = Math.max(ans, currentSubtreeSum);
        return currentSubtreeSum;
    }

    public static long maxSubtreeSum(BinaryTreeNode < Integer > root) {
        ans = Long.MIN_VALUE;
        preorderTraversal(root);
        return ans;
    }
}
