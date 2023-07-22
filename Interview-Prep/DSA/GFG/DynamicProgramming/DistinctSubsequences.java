package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequences {
    // Recursive Approach
    // TC: O(N * M)
    // SC: O(N * M)

    public int numDistinctRecursive(String s, String t) {
        int n = s.length(), m = t.length();
        
        return fRecursive(n - 1, m - 1, s, t);
    }
    
    private int fRecursive(int i, int j, String s, String t) {
        // Base Case
        if (j < 0) {
            return 1;
        }
        
        if (i < 0) {
            return 0;
        }
        
        if (s.charAt(i) == t.charAt(j)) {
            return fRecursive(i - 1, j - 1, s, t) + fRecursive(i - 1, j, s, t);
        }
        
        return fRecursive(i - 1, j, s, t);
    }

    // Memoization
    // TC:
    // SC: 
    public int numDistinctMemo(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        return f(n - 1, m - 1, s, t, dp);
    }
    
    private int f(int i, int j, String s, String t, int[][] dp) {
        // Base Case
        if (j < 0) {
            return 1;
        }
        
        if (i < 0) {
            return 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = f(i - 1, j - 1, s, t, dp) + f(i - 1, j, s, t, dp);
        }
        
        return dp[i][j] = f(i - 1, j, s, t, dp);
    }
    // Tabulation
    public int numDistinctTab(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= m; i++){
            dp[0][i] = 0; 
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }
}
