package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber1 {
    // Recursion
    public int robRecursion(int[] nums) {
        return helper(nums.length - 1, nums);
    }
    public int helper(int n, int[] nums){
        if(n < 0)
            return 0;
        return Math.max(helper(n - 2, nums) + nums[n], helper(n - 1, nums));
    }
    // Memoization
    public int robMemo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n - 1, nums, dp);
    }
    public int helper(int n, int[] nums, int[] dp){
        if(n < 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = Math.max(helper(n - 2, nums, dp) + nums[n], helper(n - 1, nums, dp));
    }
    // Tabulation
    public int robTab(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i - 2 < 0) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        } 
        return dp[n - 1];
    }
}
