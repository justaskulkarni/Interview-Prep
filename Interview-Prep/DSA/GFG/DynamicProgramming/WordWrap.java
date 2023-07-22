package DynamicProgramming;

import java.util.Arrays;

public class WordWrap {
    public int solveWordWrap (int[] nums, int k)
    {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(nums, n, k, 0, k, k, dp); 
    }
    public int helper(int[] nums, int n, int k, int wordInd, int remLen, int len, int[][] dp){
        if(wordInd == n - 1)
            return dp[wordInd][remLen] = nums[wordInd] < remLen ? 0 : (remLen * remLen);
        int currWord = nums[wordInd];
        if(currWord < remLen){
            return Math.min((remLen * remLen) + solver(nums, n, k, wordInd + 1, len - currWord, len, dp), 
                             solver(nums, n, k, wordInd + 1, remLen == len ? remLen - currWord : remLen - currWord - 1, len, dp));
        }
        return (remLen * remLen) + solver(nums, n, k, wordInd + 1, len - currWord, len, dp);
    }
    public int solver(int[] nums, int n, int k, int wordInd, int remLen, int len, int[][] dp){
        if(dp[wordInd][remLen] != -1)
            return dp[wordInd][remLen];
        return dp[wordInd][remLen] = helper(nums, n, k, wordInd, remLen, len, dp);
    }
}
