package DSA.Leetcode.Arrays.TwoPointer;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // Bruteforce Approach
        // Two Loops
        // Check if two numbers add up
        // If yes print the answer
        // TC: O(N^2)
        // SC: O(1)
        // Two Pointer
        // TC: O(N)
        // SC: O(1)
        int leftptr = 0;
        int rightptr = numbers.length - 1;
        while(leftptr < rightptr){
            int sum = numbers[leftptr] + numbers[rightptr];
            if(sum > target){
                rightptr--;
            }
            else if(sum < target){
                leftptr++;
            }
            else{
                return new int[]{leftptr + 1, rightptr + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
