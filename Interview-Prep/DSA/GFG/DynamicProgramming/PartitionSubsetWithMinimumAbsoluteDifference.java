package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionSubsetWithMinimumAbsoluteDifference {
    public static int tugOfWar(ArrayList<Integer> arr, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++)
			sum += arr.get(i);
		int[][] dp = new int[n][sum + 1];
		for(int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);
		for(int i = 0; i <= sum; i++){
			helper(arr, n - 1, i, dp);
		}
		int res = Integer.MAX_VALUE;
		for(int i = 0; i <= sum; i++){
			if(dp[n - 1][i] == 1){
				int diff = Math.abs(i - (sum - i));
				res = Math.min(res, diff);
			}
		}
		return res;
	}
	public static int helper(ArrayList<Integer> arr, int ind, int target, int[][] dp){
		if(target == 0)
			return dp[ind][target] = 1;
		if(ind == 0){
			if(arr.get(ind) == target)
				dp[ind][target] = 1;
			else
				dp[ind][target] = 0;
		}
		if(dp[ind][target] != -1)
			return dp[ind][target];
		int notTaken = helper(arr, ind - 1, target, dp);
		int Taken = 0;
		if(arr.get(ind) <= target)
			Taken = helper(arr, ind - 1, target - arr.get(ind), dp);
		return dp[ind][target] = (Taken == 1 || notTaken == 1) ? 1: 0;
	}
}
