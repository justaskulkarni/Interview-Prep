package DSA.Leetcode.Arrays;

public class LeftRotateArraybyK {
    // Bruteforce Approach
    // TC: O(N * K)
    public void rotateBrute(int[] nums, int k) {
        int n = nums.length;
        while(k-- > 0){
            int prev = nums[n - 1];
            for(int i = 0; i < n; i++){
                int temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
        }    
    }    
    // Optimized Approach
    // TC: O(N)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
