package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    // TC: O(N * M)
    // SC: O(N * M) + O(N * M)
    // Memoization
    public int longestCommonSubsequenceMemoization(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        return helper(text1, text2, n - 1, m - 1, dp);
    }
    public int helper(String text1, String text2, int ind1, int ind2, int[][] dp){
        if(ind1 < 0 || ind2 < 0)
            return 0;
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2))
            return dp[ind1][ind2] = 1 + helper(text1, text2, ind1 - 1, ind2 - 1, dp);
        return dp[ind1][ind2] = Math.max(helper(text1, text2, ind1 - 1, ind2, dp), helper(text1, text2, ind1, ind2 - 1, dp));
    }
    // Tabulation
    public int longestCommonSubsequenceTabulation(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } 
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }    
        return dp[n][m];
    }
}
