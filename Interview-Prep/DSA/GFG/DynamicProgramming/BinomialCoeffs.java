package DynamicProgramming;

public class BinomialCoeffs {
    // Space Optimized Bottom Up Tabulation
    // TC: O(N * r)
    // SC: O(r)
    static int nCr(int n, int r)
    {
        if(r > n)
            return 0;
        if((n - r) > r)
            r = n - r;
        int mod = 1000000000 + 7;
        int[] dp = new int[r + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = Math.min(r, i); j > 0; j--)
                dp[j] = (dp[j] + dp[j - 1]) % mod;
        }
        return dp[r];
    }
}
