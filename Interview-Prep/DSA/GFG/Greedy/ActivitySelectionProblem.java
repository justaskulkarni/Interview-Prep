package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {
    static class Activity{
        public int starttime;
        public int endtime;
        public Activity(int s, int e){
            starttime = s;
            endtime = e;
        }
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        Activity[] arr = new Activity[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Activity(start[i], end[i]);
        }
        Arrays.sort(arr, new Comparator<Activity>(){
            public int compare(Activity s1, Activity s2){
                return s1.endtime - s2.endtime;
            } 
        });
        int e = arr[0].endtime;
        int res = 1;
        for(int i = 1; i < n; i++){
            if(arr[i].starttime > e){
                ++res;
                e = arr[i].endtime;
            }
        }
        return res;
    }
}
