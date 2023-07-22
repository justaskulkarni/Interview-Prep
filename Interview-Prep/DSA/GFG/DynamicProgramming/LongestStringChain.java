package DynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain{
    int maxLen = 1;
    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        helper(words, new ArrayList<>(), 0, -1, dp);
        return maxLen;
    }
    public void helper(String[] words, ArrayList<String> list, int ind, int prevInd, int[] dp){
        if(ind >= words.length){
            maxLen = Math.max(maxLen, list.size());
            return ;
        }
        if(list.size() > dp[ind] && (prevInd == -1 || compare(words[prevInd], words[ind]))){
            list.add(words[ind]);
            dp[ind] = list.size();
            helper(words, list, ind + 1, ind, dp);
            list.remove(list.size() - 1);
        }
        helper(words, list, ind + 1, prevInd, dp);
    }
    public boolean compare(String s1, String s2){
        if(s1.length() + 1 != s2.length())
            return false;
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr2 < s2.length()){
            if(ptr1 < s1.length() && s1.charAt(ptr1) == s2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }
            else
                ptr2++;
        }        
        return (ptr1 == s1.length() && ptr2 == s2.length()) ? true: false;
    }
}