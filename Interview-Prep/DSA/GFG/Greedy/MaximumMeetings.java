package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumMeetings {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        int n = start.length;
        int[][] pair = new int[n][3];
        for(int i = 0; i < n; i++){
            pair[i][0] = start[i];
            pair[i][1] = end[i];
            pair[i][2] = i + 1;
        }
        Arrays.sort(pair, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int endm = pair[0][1];
        List<Integer> meetings = new ArrayList<>();
        meetings.add(pair[0][2]);
        for(int i = 1; i < n; i++){
            if(pair[i][0] > endm){
                meetings.add(pair[i][2]);
                endm = pair[i][1];
            }
        }
        return meetings;
    }
}
