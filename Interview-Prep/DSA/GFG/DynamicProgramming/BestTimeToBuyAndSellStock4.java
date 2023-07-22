package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {
    // Memoization
    // TC:O(N)
    // SC:O(N)
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }    
        return helper(prices, dp, 0, 1, k);
    }
    public int helper(int[] prices, int[][][] dp, int ind, int buy, int k){
        if(ind == prices.length || k == 0)
            return 0;
        if(dp[ind][buy][k] != -1)
            return dp[ind][buy][k];
        if(buy == 1)
            return dp[ind][buy][k] = Math.max(helper(prices, dp, ind + 1, 1, k), helper(prices, dp, ind + 1, 0, k) - prices[ind]);
        return dp[ind][buy][k] = Math.max(helper(prices, dp, ind + 1, 0, k), helper(prices, dp, ind + 1, 1, k - 1) + prices[ind]); 
    }
}
