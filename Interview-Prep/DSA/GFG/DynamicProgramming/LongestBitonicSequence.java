package DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSequence {
    // TC: O(N^2)
    // SC: O(N)
    public int LongestBitonicSequenceFunc(int[] nums)
    {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for(int i = n - 2; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(nums[i] > nums[j] && lds[i] < lds[j] + 1){
                    lds[i] = lds[j] + 1;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++)
            count = Math.max(count, lis[i] + lds[i] - 1);
        return count;
    }
}
