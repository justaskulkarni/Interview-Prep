package DynamicProgramming;

public class BestTimeToBuyAndSellStock {
    // Find the difference between the current stock and the lowest stock up until that day
    // Keep updating max to store the max of the differences found out
    // Keep updating min to find minimum price up until that point
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        int n = prices.length;
        for(int i = 1; i < n; i++){
            int curr = prices[i] - min;
            max = Math.max(max, curr);
            min = Math.min(min, prices[i]); 
        }    
        return max;
    }
}
