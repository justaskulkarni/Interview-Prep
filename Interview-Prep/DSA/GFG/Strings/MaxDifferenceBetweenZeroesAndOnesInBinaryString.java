package Strings;

public class MaxDifferenceBetweenZeroesAndOnesInBinaryString {
    int maxSubstring(String S) {
        int ans = -1;
        int count = -1;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '0'){
                if(count == -1)
                    count = 0;
                count++;
            }
            else if(S.charAt(i) == '1'){
                if(count == -1)
                    continue;
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
