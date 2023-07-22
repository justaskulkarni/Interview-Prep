package DSA.Leetcode.Arrays;

public class LargestSubarraySum {
    // Kadane's algorithm
    // TC: O(N)
    // SC: O(1)
    long maxSubarraySum(int arr[], int n){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for(int i = 0; i < n; i++){
            maxEndingHere += arr[i];
            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
            if(maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }
}
