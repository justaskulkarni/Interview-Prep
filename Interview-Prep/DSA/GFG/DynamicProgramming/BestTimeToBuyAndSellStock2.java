package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    // Recursive Solution
    // Each day there is an option of either buying or selling
    // But buying must happen before selling
    // TC: O(2^N)
    // SC: O(N)
    public int maxProfitRec(int[] prices) {
        return helperRec(prices, 0, 1);    
    }
    public int helperRec(int[] prices, int ind, int buy){
        if(ind == prices.length)
            return 0;
        if(buy == 1)
            return Math.max(helperRec(prices, ind + 1, 1), helperRec(prices, ind + 1, 0) - prices[ind]);
        return Math.max(helperRec(prices, ind + 1, 0), helperRec(prices, ind + 1, 1) + prices[ind]);
    }
    // Memoization
    // TC: O(N*2) = O(N)
    // SC: O(N*2) = O(N)
    public int maxProfitMemo(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helperMemo(prices, 0, 1, dp);    
    }
    public int helperMemo(int[] prices, int ind, int buy, int[][] dp){
        if(ind == prices.length)
            return 0;
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        if(buy == 1)
            return dp[ind][buy] = Math.max(helperMemo(prices, ind + 1, 1, dp), helperMemo(prices, ind + 1, 0, dp) - prices[ind]);
        return dp[ind][buy] = Math.max(helperMemo(prices, ind + 1, 0, dp), helperMemo(prices, ind + 1, 1, dp) + prices[ind]);
    }    
    // Tabultation
    public long maxProfitTab(int[] prices) {
        int n = prices.length;
        long[][] dp = new long[n + 1][2];
        for(long row[]: dp)
            Arrays.fill(row, -1);
        dp[n][0] = dp[n][1] = 0;
        long profit = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                if(j == 0)
                    profit = Math.max(dp[i + 1][0], dp[i + 1][1] + prices[i]);
                else
                    profit = Math.max(dp[i + 1][1], dp[i + 1][0] - prices[i]);
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
}
