package Strings;

public class SplitBinaryStringsIntoSubstrings {
    public static int maxSubStr(String str) {
        int count1 = 0;
        int count2 = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                count1++;
            else
                count2++;
            if (count1 == count2)
                res++;
        }
        if (count1 != count2)
            return -1;
        return res;
    }
}
