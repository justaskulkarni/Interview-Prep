package BinaryTree;

public class LongestPathWithGreatestSum {
    public int maxSum = Integer.MIN_VALUE;
    public int maxLen = Integer.MIN_VALUE;
    public int sumOfLongRootToLeafPath(Node root)
    {
        if(root == null)
            return 0;
        helper(root, 0, 0);
        return maxSum;
        
    }
    public void helper(Node root, int len, int sum){
        if(root == null){
            if(len > maxLen){
                maxLen = len;
                maxSum = sum;
            }
            else if(len == maxLen && sum > maxSum)
                maxSum = sum;
            return ;
        }
        helper(root.left, len + 1, sum + root.data);
        helper(root.right, len + 1, sum + root.data);
    }
}
