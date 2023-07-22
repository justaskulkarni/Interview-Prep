package DynamicProgramming;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int ind1 = s.length();
        int ind2 = s.length();
        String s2 = "";
        for(int i = ind1 - 1; i >= 0; i--)
            s2 += s.charAt(i);
        int[][] dp = new int[ind1 + 1][ind2 + 1];
        for(int i = 1; i <= ind1; i++){
            for(int j = 1; j <= ind1; j++){
                if(s.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } 
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }    
        return dp[ind1][ind1];
    }
}
