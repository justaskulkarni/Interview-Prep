package DynamicProgramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);
        return helper(prices, dp, 0, 1);
    }
    public int helper(int[] prices, int[][] dp, int ind, int buy){
        if(ind >= prices.length)
            return 0;
        if(dp[ind][buy] != -1)
            return dp[ind][buy];
        if(buy == 1)
            return dp[ind][buy] = Math.max(helper(prices, dp, ind + 1, 1), helper(prices, dp, ind + 1, 0) - prices[ind]);
        return dp[ind][buy] = Math.max(helper(prices, dp, ind + 1, 0), helper(prices, dp, ind + 2, 1) + prices[ind]);
    }
}
