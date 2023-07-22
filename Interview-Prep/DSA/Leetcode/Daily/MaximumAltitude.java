package DSA.Leetcode.Daily;
public class MaximumAltitude {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int curr = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            curr += gain[i];
            max = Math.max(curr, max);
        }   
        return max;
    }
}
