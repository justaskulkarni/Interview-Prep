package DynamicProgramming;
import java.util.Arrays;
public class Zero_One_Knapsack {
    // Recursive Approach
    // Either pick up the item or don't and update maximum possible weight after each selection
    // TC: O(2^N)
    // SC: O(N)
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        if(n == 0 || W == 0)
            return 0;
        int nottake = knapSack(W, wt, val, n - 1);
        int take = Integer.MIN_VALUE;
        if(wt[n - 1] > W)
            take = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n -1);
        return Math.max(take, nottake);
    }
    // Top Down Approach: Memoization
    // TC: O(N * W) 
    // There are N * W states so at max N * W new problems may be solved
    // SC: O(N * W) + O(N)
    // dp array and stack space
    // Here dp[i][j] represents the maximum value that can be achieved using the first i items with a maximum weight capacity of j 
    static int knapSackTD(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n][W + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(W, wt, val, n - 1, dp);
    } 
    static int helper(int W, int wt[], int val[], int n, int[][] dp){
        if(n == 0){
            if(wt[0] <= W)
                return val[0];
            return 0;
        }
        if(dp[n][W] != -1)
            return dp[n][W];
        
        int taken = Integer.MIN_VALUE;
        if(wt[n] <= W)
            taken = val[n] + helper(W - wt[n], wt, val, n - 1, dp);
        int nottaken = helper(W, wt, val, n - 1, dp);
        return dp[n][W] = Math.max(taken, nottaken);
    }
    // Bottom up Approach - Tabulation
    static int knapSackTab(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n][W + 1];
        for(int i = wt[0]; i <= W; i++)
            dp[0][i] = val[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= W; j++){
                int nottaken = dp[i - 1][j];
                int taken = Integer.MIN_VALUE;
                if(wt[i] <= j)
                    taken = val[i] + dp[i - 1][j - wt[i]];
                dp[i][j] = Math.max(taken, nottaken);
            }
        }
        return dp[n - 1][W];
    }  
}
