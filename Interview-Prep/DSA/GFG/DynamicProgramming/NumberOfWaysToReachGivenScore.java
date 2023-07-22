package DynamicProgramming;

import java.util.Arrays;

public class NumberOfWaysToReachGivenScore {
    public long count(int n) {
        long[][] dp = new long[n + 1][3];
        for(long[] row: dp)
            Arrays.fill(row, -1);
        int[] arr = new int[]{3, 5, 10};
        return helper(n, 2, arr, dp);
    }
    public long helper(int n, int ind, int[] arr, long[][] dp){
        if(n == 0)
            return 1;
        if(n < 0 || ind < 0)
            return 0;
        if(dp[n][ind] != -1)
            return dp[n][ind];
        long notTake = helper(n, ind - 1, arr, dp);
        if(arr[ind] <= n){
            long Take = helper(n - arr[ind], ind, arr, dp);
            return dp[n][ind] = Take + notTake;
        }
        return dp[n][ind] = notTake;
    }
}
