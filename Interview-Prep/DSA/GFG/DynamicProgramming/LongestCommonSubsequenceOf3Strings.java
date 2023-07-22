package DynamicProgramming;

public class LongestCommonSubsequenceOf3Strings {
    // Memoization
    public static int LCS(String a, String b, String c) {
        int la = a.length();
        int lb = b.length();
        int lc = c.length();
        int[][][] dp = new int[la][lb][lc];
        for(int i = 0; i < la; i++){
            for(int j = 0; j < lb; j++){
                for(int k = 0; k < lc; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(a, b, c, la - 1, lb - 1, lc - 1, dp);
    }
    public static int helper(String a, String b, String c, int inda, int indb, int indc, int[][][] dp){
        if(inda < 0 || indb < 0 || indc < 0)
            return 0;
        if(dp[inda][indb][indc] != -1)
            return dp[inda][indb][indc];
        if(a.charAt(inda) == b.charAt(indb) && a.charAt(inda) == c.charAt(indc))
            return dp[inda][indb][indc] = 1 + helper(a, b, c, inda - 1, indb - 1, indc - 1, dp);
        return dp[inda][indb][indc] = Math.max(Math.max(helper(a, b, c, inda - 1, indb, indc, dp),
                                    helper(a, b, c, inda, indb - 1, indc, dp)),
                           helper(a, b, c, inda, indb, indc - 1, dp));
    }
}
