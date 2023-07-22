package DynamicProgramming;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    public int maxSumIS(int arr[], int n)  
	{  
	    int[][] dp = new int[n][n + 1];
	    for(int i = 0; i < n; i++)
	        Arrays.fill(dp[i], -1);
	    return helper(arr, 0, -1, dp);
	}  
	public int helper(int[] arr, int ind, int prevInd, int[][] dp){
	    if(ind == arr.length)
	        return 0;
	    if(dp[ind][prevInd + 1] != -1)
	        return dp[ind][prevInd + 1];
	    int take = Integer.MIN_VALUE;
	    if(prevInd == -1 || arr[ind] > arr[prevInd])
	        take = arr[ind] + helper(arr, ind + 1, ind, dp);
	    int notTake = helper(arr, ind + 1, prevInd, dp);
	    return dp[ind][prevInd + 1] = Math.max(take, notTake);
	}
}
