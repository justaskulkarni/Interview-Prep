package DynamicProgramming;
import java.util.Arrays;
// First Attempt: Came up with a rough logic however could not code it up
/*  
Optimal Substructure:
To count the total number of solutions, we can divide all set solutions into two sets. 
Solutions that do not contain nth coin (or S[n-1]). 
Solutions that contain at least one S[n-1]. 
Let count(coins[], n, sum) be the function to count the number of solutions, then it can be written as sum of count(coins[], n-1, sum) and count(coins[], n, sum-coins[n-1]).
Therefore, the problem has optimal substructure property as the problem can be solved using solutions to subproblems. 
*/
public class CoinChange {
    // Recursive Approach
    // TC: O(2^sum)
    // SC: O(target) 
    public long count(int coins[], int N, int sum) {
        if(sum == 0)
            return 1;
        if(sum < 0)
            return 0;
        if(N <= 0)
            return 0;
        return count(coins, N - 1, sum) + count(coins, N, sum - coins[N - 1]);
    }
    // DP
    // TC:
    // SC:
    long solveMem( int index, int coins[], int target, long dp[][]){
        if(target==0){
            return 1;
        }
        if(index==0){
            if(target%coins[0]==0){
                return 1;
            }
            return 0;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        long pick = 0;
        if(coins[index]<=target){
            pick = solveMem(index,coins,target-coins[index],dp);
        }
        long notPick = solveMem(index-1,coins, target, dp);
        return dp[index][target]=pick+notPick;
    }
    
    public long countDP(int coins[], int n, int sum) {
        
        long dp[][] = new long[n][sum+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        long ans = solveMem(n-1,coins,sum,dp);
        return ans;
    } 
}
