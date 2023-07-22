package DSA.Leetcode.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int leftptr = 0;
        int rightptr = 1;
        int n = nums.length;
        while(rightptr != n){
            if(nums[leftptr] != 0){
                leftptr++;
                rightptr++;
                continue;
            }
            if(nums[rightptr] == 0){
                rightptr++;
                continue;
            }
            swap(nums, leftptr, rightptr);
            leftptr++;
            rightptr++;
        }    
    }
    public void swap(int[] nums, int leftptr, int rightptr){
        int temp = nums[leftptr];
        nums[leftptr] = nums[rightptr];
        nums[rightptr] = temp;
    }    
}
