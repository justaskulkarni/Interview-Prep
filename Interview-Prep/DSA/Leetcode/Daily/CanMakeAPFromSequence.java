package DSA.Leetcode.Daily;
import java.util.Arrays;
public class CanMakeAPFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int diff = arr[1] - arr[0];
        for(int i = 2; i < n; i++){
            if(arr[i] - arr[0] != i * diff)
                return false;
        }
        return true;
    }
}
