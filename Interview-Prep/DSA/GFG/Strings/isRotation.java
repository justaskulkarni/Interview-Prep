package Strings;

import java.util.ArrayList;

public class isRotation {
    // Bruteforce approach
    // TC: O(N^2)
    // SC: O(N)
    static boolean checkString(String s1, String s2,
                               int indexFound, int Size)
    {
        for (int i = 0; i < Size; i++) {
 
            // check whether the character is equal or not
            if (s1.charAt(i)
                != s2.charAt((indexFound + i) % Size))
                return false;
 
            // %Size keeps (indexFound+i) in bounds,
            // since it ensures it's value is always less
            // than Size
        }
 
        return true;
    }
 
    // Driver code
    public static void main(String args[])
    {
        String s1 = "abcd";
        String s2 = "cdab";
 
        if (s1.length() != s2.length()) {
            System.out.println(
                "s2 is not a rotation on s1");
        }
        else {
 
            ArrayList<Integer> indexes = new ArrayList<
                Integer>(); // store occurrences of the
                            // first character of s1
 
            int Size = s1.length();
 
            char firstChar = s1.charAt(0);
 
            for (int i = 0; i < Size; i++) {
                if (s2.charAt(i) == firstChar) {
                    indexes.add(i);
                }
            }
 
            boolean isRotation = false;
 
            // check if the strings are rotation of each
            // other for every occurrence of firstChar in s2
            for (int idx : indexes) {
                isRotation = checkString(s1, s2, idx, Size);
 
                if (isRotation)
                    break;
            }
 
            if (isRotation)
                System.out.println(
                    "Strings are rotations of each other");
            else
                System.out.println(
                    "Strings are not rotations of each other");
        }
    }

    // Using queues

    static boolean areRotationsQueue(String s1, String s2)
    {
        /* Check if sizes of two strings are same */
        if (s1.length() != s2.length()) {
            return false;
        }
        else {
            for (int i = 0; i < s1.length(); i++) {
                // checking character at ith index with
                // first character of s2
                if (s1.charAt(i) == s2.charAt(0)) {
                    // checking prefix of s2 with suffix of
                    // s1
                    if (s1.substring(i).equals(s2.substring(
                            0, s1.length() - i))) {
                        // checking prefix of s1 with suffix
                        // of s2
                        if (s1.substring(0, i).equals(
                                s2.substring(s1.length()
                                             - i)))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    // Optimized Approach
    // Concatenate the second string with itself and check if the concatenated string contains the first string 
    // TC: O(N) as indexOf method has time complexity of O(N)
    // SC: O(1)
    static boolean areRotations(String str1, String str2) {
        return (str1.length() == str2.length())
                && ((str1 + str1).indexOf(str2) != -1);
    }
}
