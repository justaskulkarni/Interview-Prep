package Greedy;

import java.util.Arrays;

public class CompareAndSwap {
    // Approach
    // Make an array to store first index of every unique character in the string
    // If character not present it will marked as 0
    // Traverse the string from left to right
    // For every character, search the array for every character lexicographically smaller than the character at hand
    // If there exists a lexicographically smaller character and it happens to have index greater than the index of the character at hand then we have found the two characters to be swapped
    String chooseandswap(String A){
        int l = A.length();
        int[] set = new int[26];
        Arrays.fill(set, -1);
        for(int i = 0; i < l; i++){
            if(set[A.charAt(i) - 'a'] != -1)
                set[A.charAt(i) - 'a'] = i;
        }
        int i = 0, j = 0;
        for(; i < l; i++){
            boolean flag = false;
            for(; j < (A.charAt(i) - 'a'); j++){
                if(set[j] > set[A.charAt(i) - 'a']){
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        if(i < l - 1){
            char c1 = A.charAt(i);
            char c2 = (char)(j + 'a');
            for(int k = 0; k < l; k++){
                if(A.charAt(k) == c1)
                    // Swap
                else if(A.charAt(k) == c2)
                    // Swap
            }
        }
        return A;
    }
}
