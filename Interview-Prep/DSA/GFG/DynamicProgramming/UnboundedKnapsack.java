package DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W + 1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return unboundedKnapsack(W, wt, val, N - 1, dp);
    }
    static int unboundedKnapsack(int W, int[] wt, int[] val, int idx, int[][] dp){
        if (idx == 0) {
            return (W / wt[0]) * val[0];
        }
 
        // If the value is already calculated then we will
        // previous calculated value
        if (dp[idx][W] != -1)
            return dp[idx][W];
        // There are two cases either take element or not
        // take. If not take then
        int notTake
            = 0
              + unboundedKnapsack(W, wt, val, idx - 1, dp);
        // if take then weight = W-wt[idx] and index will
        // remain same.
        int take = Integer.MIN_VALUE;
        if (wt[idx] <= W) {
            take = val[idx]
                   + unboundedKnapsack(W - wt[idx], wt, val,
                                       idx, dp);
        }
        return dp[idx][W] = Math.max(take, notTake);
    }
}
