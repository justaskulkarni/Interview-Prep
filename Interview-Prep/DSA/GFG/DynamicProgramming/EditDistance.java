package DynamicProgramming;
import java.util.Arrays;
public class EditDistance {
    /*
    Insert: Recur for m and n-1
    Remove: Recur for m-1 and n
    Replace: Recur for m-1 and n-1
     */
    // Recursive solution
    // TC: O(3^N)
    // SC: O(N)
    public int editDistanceRecursion(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        return helper(i, j, s, t);
    }
    public int helper(int i, int j, String s, String t){
        if(i < 0)
            return j + 1;
        if(j < 0)
            return i + 1;
        if(s.charAt(i) == t.charAt(j))
            return helper(i - 1, j - 1, s, t);
        return 1 + Math.min(helper(i - 1, j - 1, s, t), Math.min(helper(i - 1, j, s, t), helper(i, j - 1, s, t)));
    }
    // Memoization
    public int editDistanceMemo(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int[][] dp = new int[i + 1][j + 1];
        for(int k = 0; k <= i; k++)
            Arrays.fill(dp[k], -1);
        return helperMemo(i, j, s, t, dp);
    }
    public int helperMemo(int i, int j, String s, String t, int[][] dp){
        if(i < 0)
            return j + 1;
        if(j < 0)
            return i + 1;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = helperMemo(i - 1, j - 1, s, t, dp);
        return dp[i][j] = 1 + Math.min(helperMemo(i - 1, j - 1, s, t, dp), Math.min(helperMemo(i - 1, j, s, t, dp), helperMemo(i, j - 1, s, t, dp)));
    }
    // Tabulation
    public int minDistanceTab(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = i;
        for(int i = 0; i <= m; i++)
            dp[0][i] = i;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[n][m];
    }
}
