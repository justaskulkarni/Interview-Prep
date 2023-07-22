package DynamicProgramming;
import java.util.Arrays;
public class TallestBillboard {
    // Recursion
    // 3 Variable Approach
    public int tallestBillboardTwoVariableRecursion(int[] rods) {
        return helper(rods, rods.length - 1, 0, 0);
    }

    public int helper(int[] rods, int ind, int sum1, int sum2) {
        if (ind < 0) {
            if (sum1 == sum2)
                return sum1;
            return Integer.MIN_VALUE;
        }
        int take = helper(rods, ind - 1, sum1 + rods[ind], sum2);
        int notTake = helper(rods, ind - 1, sum1, sum2 + rods[ind]);
        int skip = helper(rods, ind - 1, sum1, sum2);
        return Math.max(take, Math.max(notTake, skip));
    }
    // Recursion
    // 2 Variable Approach
    public int tallestBillboardThreeVariableRecursion(int[] rods) {
        return helper(rods, rods.length - 1, 0);
    }
    public int helper(int[] rods, int ind, int diff){
        if(ind < 0){
            if(diff == 0)
                return 0;
            return Integer.MIN_VALUE;
        }
        int take = rods[ind] + helper(rods, ind - 1, diff + rods[ind]);
        int notTake = helper(rods, ind - 1, diff - rods[ind]);
        int skip = helper(rods, ind - 1, diff);
        return Math.max(take, Math.max(notTake, skip)); 
    }
    // Tallest Billboard
    public int tallestBillboardMemo(int[] rods) {
        int n = rods.length;
        int[][] dp = new int[n][10000];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(rods, rods.length - 1, 0, dp);
    }
    public int helper(int[] rods, int ind, int diff, int[][] dp){
        if(ind < 0){
            if(diff == 0)
                return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[ind][diff + 5000] != -1)
            return dp[ind][diff + 5000];
        int take = rods[ind] + helper(rods, ind - 1, diff + rods[ind], dp);
        int notTake = helper(rods, ind - 1, diff - rods[ind], dp);
        int skip = helper(rods, ind - 1, diff, dp);
        return dp[ind][diff + 5000] = Math.max(take, Math.max(notTake, skip)); 
    }
}