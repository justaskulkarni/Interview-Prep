package DynamicProgramming;

import java.util.Arrays;

public class CountAllNodesWithProductLessThanK {
    public static int countSubsequences(int[] a, int n, int p) {
        int[][] dp = new int[n][p + 1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return helper(a, n - 1, 1, p, dp);
    }
    public static int helper(int[] a, int ind, int curr, int p, int[][] dp){
        if(ind < 0){
            return 0;
        }
        if(dp[ind][curr] != -1)
            return dp[ind][curr];
        int notTake = helper(a, ind - 1, curr, p, dp);
        int Take = 0;
        if(curr * a[ind] <= p)
            Take = 1 + helper(a, ind - 1, curr * a[ind], p, dp);
        return dp[ind][curr] = Take + notTake;
    }
}
