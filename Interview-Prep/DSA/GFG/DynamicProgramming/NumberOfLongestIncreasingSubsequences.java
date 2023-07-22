package DynamicProgramming;

public class NumberOfLongestIncreasingSubsequences {
    // TC: O(N^2)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        int maxLength = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            helper(nums, i, length, count);
            maxLength = Math.max(maxLength, length[i]);
        }
        for(int i = 0; i < n; i++){
            if(length[i] == maxLength)
                res += count[i];
        }
        return res;
    }
    public void helper(int[] nums, int ind, int[] length, int[] count){
        if(length[ind] != 0)
            return ;
        length[ind] = 1;
        count[ind] = 1;
        for(int j = 0; j < ind; j++){
            if(nums[j] < nums[ind]){
                helper(nums, j, length, count);
                if(length[j] + 1 > length[ind]){
                    length[ind] = length[j] + 1;
                    count[ind] = 0; 
                }
                if(length[j] + 1 == length[ind]){
                    count[ind] += count[j];
                }
            }
        }
    }
}
