package DSA.Leetcode.Arrays.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    // Optimized Approach
    // Sort the array
    // 3 pointers in total 
    // Pointer1: Goes from 0 to N - 1
    // Pointer2: Starts at (Pointer1 + 1)
    // Pointer3: Start from (N - 1)
    // Take advantage of the fact that we have them sorted
    // If sum is greater than zero, decrement Pointer3
    // If sum is less than zero, increment Pointer2
    // If sum is equal to zero, increment Pointer2 and decrement Pointer3
    // TC: O(N)
    // SC: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }    
        return new ArrayList<>(set);
    }
}
