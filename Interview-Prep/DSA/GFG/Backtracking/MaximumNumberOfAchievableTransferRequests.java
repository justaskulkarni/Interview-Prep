package Backtracking;

public class MaximumNumberOfAchievableTransferRequests {
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return helper(requests, indegree, 0, 0, n);         
    }
    public int helper(int[][] requests, int[] indegree, int ind, int count, int n){
        if(ind == requests.length){
            for(int i = 0; i < n; i++){
                if(indegree[i] != 0)
                    return 0;
            }
            return count;
        }
        // Grant
        indegree[requests[ind][0]]--;
        indegree[requests[ind][1]]++;

        int grant = helper(requests, indegree, ind + 1, count + 1, n);

        // Not Grant
        indegree[requests[ind][0]]++;
        indegree[requests[ind][1]]--;

        int notGrant = helper(requests, indegree, ind + 1, count, n);

        return Math.max(grant, notGrant);
    }
}
