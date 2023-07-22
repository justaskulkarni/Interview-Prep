package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubstring {
    // Recursive Approach
    public static int lcs(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		return helper(str1, str2, n - 1, m - 1, 0);
	}
	public static int helper(String str1, String str2, int ind1, int ind2, int count){
		if(ind1 < 0 || ind2 < 0)
			return count;
		if(str1.charAt(ind1) == str2.charAt(ind2))
			count = helper(str1, str2, ind1 - 1, ind2 - 1, count + 1);
		count = Math.max(count, Math.max(helper(str1, str2, ind1 - 1, ind2, 0), helper(str1, str2, ind1, ind2 - 1, 0)));
		return count;
	}
	// Memoization
	public static int lcsMemo(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int l = n > m ? m: n;
		int[][][] dp = new int[n + 1][m + 1][l + 1];
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= m; j++)
				Arrays.fill(dp[i][j], -1);
		return helper(str1, str2, n - 1, m - 1, 0, dp);
	}
	public static int helper(String str1, String str2, int ind1, int ind2, int count, int[][][] dp){
		if(ind1 < 0 || ind2 < 0)
			return count;
		if(dp[ind1][ind2][count] != -1)
			return dp[ind1][ind2][count];
		int temp = count;
		if(str1.charAt(ind1) == str2.charAt(ind2))
			count = helper(str1, str2, ind1 - 1, ind2 - 1, count + 1, dp);
		return dp[ind1][ind2][temp] = Math.max(count, Math.max(helper(str1, str2, ind1 - 1, ind2, 0, dp), helper(str1, str2, ind1, ind2 - 1, 0, dp)));
	}
}
