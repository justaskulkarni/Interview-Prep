package DynamicProgramming;

import java.util.Arrays;

public class PairsWithSpecificDifference {
    // Recursive solution
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        Arrays.sort(arr);
        return helper(arr, 1, K);
    }
    public static int helper(int arr[], int ind, int K){
        if(ind >= arr.length)
            return 0;
        if(arr[ind] - arr[ind - 1] < K)
            return Math.max(arr[ind] + arr[ind - 1] + helper(arr, ind + 2, K), helper(arr, ind + 1, K));
        return helper(arr, ind + 1, K);
    }
    // Memoization
    public static int maxSumPairWithDifferenceLessThanKMemo(int arr[], int N, int K) 
    {
        Arrays.sort(arr);
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return helper(arr, 1, K, dp);
    }
    public static int helper(int arr[], int ind, int K, int[] dp){
        if(ind >= arr.length)
            return 0;
        if(dp[ind] != -1)
            return dp[ind];
        if(arr[ind] - arr[ind - 1] < K)
            return dp[ind] = Math.max(arr[ind] + arr[ind - 1] + helper(arr, ind + 2, K, dp), helper(arr, ind + 1, K, dp));
        return dp[ind] = helper(arr, ind + 1, K, dp);
    }
}
