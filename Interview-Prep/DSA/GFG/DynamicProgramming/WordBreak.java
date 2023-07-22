package DynamicProgramming;

import java.util.List;

public class WordBreak {
    // Recursion
    // TC: O(2 ^ N)
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        for(int i = 0; i < s.length(); i++){
            String left = s.substring(0, i + 1);
            if(wordDict.contains(left) && wordBreak(s.substring(i + 1), wordDict))
                return true;
        }    
        return false;
    }
    // Tabulation
    public boolean wordBreakTab(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i)))
                    dp[i] = true;
            }
        }   
        return dp[n];
    }
}
