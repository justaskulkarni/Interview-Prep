package DSA.Leetcode.Daily;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    // Bruteforce Approach
    // TC: O(N)
    // SC: O(N)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }    
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
    // Better Bruteforce Approach
    // Sort the array
    // Iterate from index 1 to n - 2
    // When sorted, all the duplicate (frequency 3) numbers will be bunched together, with one oddball
    // For every index, check if it matches with its neighbouring two elements
}
