package DynamicProgramming;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public int LongestRepeatingSubsequenceMemo(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(str, n - 1, n - 1, dp);
    }
    public int helper(String str, int ind1, int ind2, int[][] dp){
        if(ind1 < 0 || ind2 < 0)
            return 0;
        if(dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if(str.charAt(ind1) == str.charAt(ind2) && ind1 != ind2)
            return dp[ind1][ind2] = 1 + helper(str, ind1 - 1, ind2 - 1, dp);
        return dp[ind1][ind2] = Math.max(helper(str, ind1, ind2 - 1, dp), helper(str, ind1 - 1, ind2, dp));
    }
}
