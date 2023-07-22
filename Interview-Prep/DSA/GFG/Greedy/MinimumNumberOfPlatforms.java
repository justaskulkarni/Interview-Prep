package Greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int plats = 1;
        int totaldept = 0;
        for(int i = 1; i < n; i++){
            if(at[i] > dt[totaldept])
                totaldept++;
            else
                plats++;
        }
        return plats;
    }
}
