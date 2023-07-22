package DynamicProgramming;

import java.util.Arrays;

public class PartitionSubsetSum {
    // Recursive Approach
    // TC: (2^N)
    static int equalPartition(int N, int arr[])
    {
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 == 1)
            return 0;
        sum /= 2;
        if(helper(arr, N - 1, sum))
            return 1;
        return 0;
    }
    static boolean helper(int[] arr, int N, int target){
        if(target == 0)
            return true;
        if(N == 0){
            return (arr[N] == target);
        }
        boolean nottake = helper(arr, N - 1, target);
        boolean take = false;
        if(arr[N] <= target)
            take = helper(arr, N - 1, target - arr[N]);
        return take || nottake;
    }
    // Memoization
    // TC: O(N*Sum)
    // SC: O(Sum)
    static int equalPartitionMemo(int N, int arr[])
    {
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 == 1)
            return 0;
        sum /= 2;
        int[][] dp = new int[N][sum + 1];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }
        if(helperMemo(arr, N - 1, sum, dp))
            return 1;
        return 0;
    }
    static boolean helperMemo(int[] arr, int N, int target, int[][] dp){
        if(target == 0)
            return true;
        if(N == 0){
            return (arr[N] == target);
        }
        if(dp[N][target] != -1)
            return dp[N][target] == 0 ? false: true;
        boolean nottake = helperMemo(arr, N - 1, target, dp);
        boolean take = false;
        if(arr[N] <= target)
            take = helperMemo(arr, N - 1, target - arr[N], dp);
            dp[N][target] = nottake || take ? 1: 0;
        return take || nottake;
    }
    // Tabulation
    static int equalPartitionTab(int N, int arr[])
    {
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 == 1)
            return 0;
        sum /= 2;
        boolean[][] dp = new boolean[N][sum + 1];
        for(int i = 0; i < N; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum)
            dp[0][arr[0]] = true;
        for(int i = 1; i < N; i++){
            for(int target = 1; target <= sum; target++){
                boolean nottake = dp[i - 1][target];
                boolean take = false;
                if(arr[i] <= target)
                    take = dp[i - 1][target - arr[i]];
                dp[i][target] = nottake || take;
            }
        }
        if(dp[N - 1][sum])
            return 1;
        return 0 ;
    }
    /*
     *              [1, 4, 5, 6, 2]
     *              []
     *              
     *          []        [2]        
     *          
     *       []   [6]     [2]  [6, 2]
     *      
     *     [][5] [6][6,5] 
     */
}
