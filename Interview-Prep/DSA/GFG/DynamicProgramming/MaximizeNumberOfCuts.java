package DynamicProgramming;

import java.util.Arrays;

public class MaximizeNumberOfCuts {
    // Memoization
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] arr = new int[]{x, y, z};
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        Arrays.sort(arr);
        int ans = helper(n, arr, dp);
        if(ans < 0)
            return 0;
        return ans;
    }
    public int helper(int n, int[] arr, int[] dp){
        if(n == 0)
            return 0;
        if(n < 0)   
            return Integer.MIN_VALUE;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = 1 + Math.max(helper(n - arr[0], arr, dp), Math.max(helper(n - arr[1], arr, dp), helper(n - arr[2], arr, dp)));
    }
}
