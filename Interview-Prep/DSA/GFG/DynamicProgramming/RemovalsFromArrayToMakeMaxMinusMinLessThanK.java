package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemovalsFromArrayToMakeMaxMinusMinLessThanK {
    // Recursion
    public static int minRemovals(ArrayList<Integer> arr, int n, int k) {
        Collections.sort(arr);
        return helper(arr, 0, arr.size() - 1, k);
    }
    public static int helper(ArrayList<Integer> arr, int start, int end, int k){
        if(start < 0 || end >= arr.size())
            return 0;
        if(isValid(arr, start, end, k))
            return 0;
        return 1 + Math.min(helper(arr, start + 1, end, k), helper(arr, start, end - 1, k));
    }
    public static boolean isValid(ArrayList<Integer> arr, int start, int end, int k){
        if(arr.get(end) - arr.get(start) <= k)
            return true;
        return false;
    }
    // Memoization
    public static int minRemovalsMemo(ArrayList<Integer> arr, int n, int k) {
        Collections.sort(arr);
        int[][] dp = new int[n][n];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return helperMemo(arr, 0, arr.size() - 1, k, dp);
    }
    public static int helperMemo(ArrayList<Integer> arr, int start, int end, int k, int[][] dp){
        if(start < 0 || end >= arr.size())
            return 0;
        if(dp[start][end] != -1)
            return dp[start][end];
        if(isValid(arr, start, end, k))
            return dp[start][end] = 0;
        return dp[start][end] = 1 + Math.min(helperMemo(arr, start + 1, end, k, dp), helperMemo(arr, start, end - 1, k, dp));
    }
    public static boolean isValidMemo(ArrayList<Integer> arr, int start, int end, int k){
        if(arr.get(end) - arr.get(start) <= k)
            return true;
        return false;
    }
}
