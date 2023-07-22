package DSA.Leetcode.Arrays;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = n * (n + 1) / 2;
        int sum2 = Arrays.stream(nums).sum();
        return sum1 - sum2;
    }
}
