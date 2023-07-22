package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {
   // Memoization
   // TC: O(N)
   // SC: O(N)
   public int maxProfitMemo(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < 2; j++)
                Arrays.fill(dp[i][j], -1);
        return helper(prices, dp, 0, 1, 2);
    }
    public int helper(int[] prices, int[][][] dp, int ind, int buy, int count){
        if(ind == prices.length || count == 0)
            return 0;
        if(dp[ind][buy][count] != -1)
            return dp[ind][buy][count];
        if(buy == 1)
            return dp[ind][buy][count] = Math.max(helper(prices, dp, ind + 1, 1, count), helper(prices, dp, ind + 1, 0, count) - prices[ind]);
        return dp[ind][buy][count] = Math.max(helper(prices, dp, ind + 1, 0, count), helper(prices, dp, ind + 1, 1, count - 1) + prices[ind]); 
    } 
}
