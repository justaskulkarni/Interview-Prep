package DSA.Leetcode.Graphs;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for(int[] arr: trust){
            count[arr[0]]--;
            count[arr[1]]++;
        }   
        for(int i = 1; i <= n; i++){
            if(count[i] == n - 1)
                return i;
        }
        return -1;
    }
}
