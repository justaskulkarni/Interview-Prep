package DynamicProgramming;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0], nums[1]);
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        for(int i = 0; i < n; i++){
            if(i < n - 1)
                arr1[i] = nums[i];
            if(i > 0)
                arr2[i - 1] = nums[i];
        }
        return Math.max(helper(arr1), helper(arr2));
    }
    public int helper(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i = 1; i < n; i++){
            if(i < 2)
                dp[i] = Math.max(dp[i - 1], arr[i]);
            else
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
