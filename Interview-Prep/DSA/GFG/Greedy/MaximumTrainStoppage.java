package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumTrainStoppage {
    public static int maxStop(int[][] trains, int n, int m) {
            Arrays.sort(trains, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    int diff = a[2] - b[2];
                    if(diff == 0){
                        diff = a[1] - b[1];
                    }
                    return diff;
                }
            }); 
            int count = 0;
            int idx = 0;           
            for(int i = 1; i <= m; i++){
                int endTime = 0;
                while(idx < n && (trains[idx][2] == i)){
                    if(trains[idx][0] >= endTime){
                        count++;
                        endTime = trains[idx][1];
                    }
                    idx++;
                }
            }
            return count;
        }
}
