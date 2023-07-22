package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    // Memoization
    // TC: O(N*2)
    // SC: O(N)
    // Consider [1, 2, 3, 4, 6, 8, 9, 12]
    // One subsequence can be [1, 2, 4, 8]
    // And another could be [1, 2, 4, 12]
    // So once one recursive call is completed, we must remove last element from the subsequence and then again go searching in the rest of the array
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        helper(temp, 0, 1, nums, dp);
        return res;    
    }
    public void helper(List<Integer> temp, int ind, int prev, int[] nums, int[] dp){
        if(ind >= nums.length){
            if(temp.size() > res.size())
                res = new ArrayList<>(temp);
            return ;
        }
        if((int)temp.size() > dp[ind] && nums[ind] % prev == 0){
            dp[ind] = temp.size();
            temp.add(nums[ind]);
            helper(temp, ind + 1, nums[ind], nums, dp);
            temp.remove(temp.size() - 1);
        }
        helper(temp, ind + 1, prev, nums, dp);
    }
}
