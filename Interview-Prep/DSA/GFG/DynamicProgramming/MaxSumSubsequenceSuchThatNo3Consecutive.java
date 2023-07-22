package DynamicProgramming;

import java.util.Arrays;

public class MaxSumSubsequenceSuchThatNo3Consecutive {
    int findMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(arr, n - 1, dp);
    }
    int helper(int[] arr, int ind, int[] dp){
        if(ind < 0)
            return 0;
        if(ind == 0)
            return arr[ind];
        if(dp[ind] != -1)
            return dp[ind];
        int opt1 = arr[ind] + arr[ind - 1] + helper(arr, ind - 3, dp);
        int opt2 = arr[ind] + helper(arr, ind - 2, dp);
        int opt3 = helper(arr, ind - 1, dp);
        return dp[ind] = Math.max(opt1, Math.max(opt2, opt3));
    }
}
