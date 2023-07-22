package DSA.Leetcode.Arrays;

public class RemoveDuplicatesFromSortedArray {
    // Optimized Approach
    // TC: O(N)
    // SC: O(1)
    public int removeDuplicates(int[] arr) {
        int i = 0;
        int n = arr.length;
        for(int j = 1; j < n; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }    
        return i + 1;
    }
}
