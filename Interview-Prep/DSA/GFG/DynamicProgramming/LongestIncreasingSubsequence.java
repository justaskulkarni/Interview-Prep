package DynamicProgramming;
import java.util.Arrays;

public class LongestIncreasingSubsequence{
    // Memoization
    // TC: O(N^2)
    // SC: O(N^2)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(nums, dp, 0, -1);        
    }
    public int helper(int[] nums, int[][] dp, int ind, int prevInd){
        if(ind == nums.length)
            return 0;
        if(dp[ind][prevInd + 1] != -1)
            return dp[ind][prevInd + 1];
        int notTake = helper(nums, dp, ind + 1, prevInd);
        int take = 0;
        if(prevInd == -1 || nums[ind] > nums[prevInd])
            take = 1 + helper(nums, dp, ind + 1, ind);
        return dp[ind][prevInd + 1] = Math.max(take, notTake);
    }
}