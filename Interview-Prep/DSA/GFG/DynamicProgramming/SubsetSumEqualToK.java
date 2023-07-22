package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumEqualToK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(n - 1, k, arr, dp);
    }
    public static boolean helper(int n, int target, int[] arr, int[][] dp){
        if(target == 0)
            return true;
        if(n == 0)
            return target == arr[0];
        if(dp[n][target] != -1)
            return dp[n][target] == 0 ? false: true;
        boolean nottake = helper(n - 1, target, arr, dp);
        boolean take = false;
        if(arr[n] <= target)
            take = helper(n - 1, target - arr[n], arr, dp);
        dp[n][target] = take || nottake ? 1: 0;
        return take || nottake;
    }
}
