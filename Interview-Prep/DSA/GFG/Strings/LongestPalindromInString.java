package Strings;

public class LongestPalindromInString {
    // Brute force method
    /*
     * Maintain two pointers
     * i from 0 to len(s)
     * j from i to len(s)
     * Using the two pointers, find all substrings and add them to a list
     * Traverse the list and search for the longest palindromic substring
     * TC: O(N^3)  since two loops for two pointers, plus creation of substring and adding it to the list
     * SC: O(N^2)
     */
    // Optimized Approach
    static String res;
    static int maxLength;
    static String longestPalin(String str){
        res = "";
        maxLength = 1;
        // for every index in the string check palindromes
        // starting from that index
        for (int i = 0; i < str.length(); i++) {
            // check for odd length palindromes
            cSubUtil(str, i, i);
            // check for even length palindromes
            cSubUtil(str, i, i + 1);
        }
        return res;
    
    }
    static void cSubUtil(String s, int l, int r)
    {
        // check if the indices lie in the range of string
        // and also if it is palindrome
        while (l >= 0 && r < s.length()
               && s.charAt(l) == s.charAt(r)) {
            // expand the boundary
            l--;
            r++;
        }
        // if it's length is greater than maxLength update
        // maxLength and res
        if (r - l - 1 >= maxLength) {
            res = s.substring(l + 1, r);
            maxLength = r - l - 1;
        }
        return;
    }
}
