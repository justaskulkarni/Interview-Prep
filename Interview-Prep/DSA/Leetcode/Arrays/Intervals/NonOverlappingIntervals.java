package DSA.Leetcode.Arrays.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1])
                    return b[0] - a[0];
                return a[1] - b[1];
            }
        });
        int ans = 0;
        int prevInt = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            if(prevInt > interval[0])
                ans++;
            else
                prevInt = interval[1];
        }
        return ans;
    }
}
