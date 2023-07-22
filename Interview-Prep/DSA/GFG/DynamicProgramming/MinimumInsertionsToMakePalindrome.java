package DynamicProgramming;

import java.util.Arrays;

public class MinimumInsertionsToMakePalindrome {
    // Recursive Approach
    // TC: O(2^N)
    // SC: O(N)
    public int minInsertions(String s) {
        int n = s.length();
        return helper(s, 0, n - 1);
    }
    public int helper(String s, int low, int high){
        if(low == high)
            return 0;
        if(low == high - 1)
            return (s.charAt(low) == s.charAt(high)) ? 0: 1;
        if(s.charAt(low) == s.charAt(high))
            return helper(s, low + 1, high - 1);
        return 1 + Math.min(helper(s, low + 1, high), helper(s, low, high - 1));
    }
    // Memoization
    // TC: O(N^2)
    // SC: O(N^2)
    public int minInsertionsMemo(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        return helper(s, 0, n - 1, dp);
    }
    public int helper(String s, int low, int high, int[][] dp){
        if(low == high)
            return 0;
        if(low == high - 1)
            return (s.charAt(low) == s.charAt(high)) ? 0: 1;
        if(dp[low][high] != -1)
            return dp[low][high];
        if(s.charAt(low) == s.charAt(high))
            return dp[low][high] = helper(s, low + 1, high - 1, dp);
        return dp[low][high] = 1 + Math.min(helper(s, low + 1, high, dp), helper(s, low, high - 1, dp));
    } 
}
