package DynamicProgramming;

import java.util.Arrays;

public class FrogJumps {
    // Memoization
    // TC: O(N)
    // SC: O(N)
    public static int frogJumpMemo(int n, int heights[]) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n - 1, heights, dp);
    }
    public static int helper(int n, int[] heights, int[] dp){
        if(n == 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        int b = Integer.MAX_VALUE;
        int a = helper(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        if(n > 1)
            b = helper(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        return dp[n] = Math.min(a, b);
    }
    // Tabulation
    // TC: O(N)
    // SC: O(N)
    public static int frogJumpTab(int n, int heights[]) {
        if(n == 1)
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        for(int i = 2; i < n; i++){
            int a = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int b = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(a, b);
        }
        return dp[n - 1];
    }
}
