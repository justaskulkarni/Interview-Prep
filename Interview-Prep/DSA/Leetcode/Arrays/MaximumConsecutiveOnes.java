package DSA.Leetcode.Arrays;

public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ans = 0;
        for(int num: nums){
            if(num == 1){
                count++;
            }
            else{
                ans = Math.max(ans, count);
                count = 0;
            }
        }    
        ans = Math.max(ans, count);
        return ans;
    }
}
