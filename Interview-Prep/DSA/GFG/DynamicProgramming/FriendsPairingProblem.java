package DynamicProgramming;
import java.util.Arrays;
public class FriendsPairingProblem {
    // Memoization
    // TC: O(N^2)
    // SC: O(N)
    int mod = 1000000007;
    public long countFriendsPairings(int n) 
    { 
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countFriendsPairingsUtil(n, dp);
    }
    static int countFriendsPairingsUtil(int n, int[] dp)
    {
        if (dp[n] != -1)
            return dp[n];
 
        if (n > 2)
            return dp[n] = countFriendsPairingsUtil(n - 1, dp) + (n - 1) * countFriendsPairingsUtil(n - 2, dp);
        else
            return dp[n] = n;
    }
    // Tabulation
    public long countFriendsPairingsTabulation(int n) 
    { 
        if(n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = ((dp[i - 1] % mod) + ((i - 1) * dp[i - 2]) % mod) % mod;
        }
        return dp[n];
    }
    // Space optimized iterative
    public long countFriendsPairingsSpaceOptimizedIterative(int n) 
    { 
       int a = 1, b = 2, c = 0;
       if(n <= 2)
        return n;
       for(int i = 3; i <= n; i++){
           c = b + (i - 1) * a;
           a = b;
           b = c;
       }
       return c;
    }
}
