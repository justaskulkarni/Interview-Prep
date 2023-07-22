package DynamicProgramming;

public class LongestArithmeticSequenceOfGivenDifference {
    // Recursive Approach
    public int longestSubsequence(int[] arr, int difference) {
        return helper(arr, 0, -10000, difference);
    }
    public int helper(int[] arr, int ind, int prev, int difference){
        if(ind >= arr.length)
            return 0;
        int notTake = 0;
        int Take = 0;
        if(prev == -10000){
            notTake = helper(arr, ind + 1, prev, difference);
            Take = 1 + helper(arr, ind + 1, arr[ind], difference);
        }
        else{
            notTake = helper(arr, ind + 1, prev, difference);
            if(arr[ind] - prev == difference)
                Take = 1 + helper(arr, ind + 1, arr[ind], difference);
        }
        return Math.max(notTake, Take);
    }
}
