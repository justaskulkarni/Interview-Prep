package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}


public class JobSequencing {
    // Bruteforce Approach
    // TC: O(N^2)
    // SC: O(N)
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job j1, Job j2){
                return j2.profit - j1.profit;
            } 
        });
        int[] res = new int[]{0, 0};
        boolean[] occupied = new boolean[n]; 
        for(int i = 0; i < n; i++){
            for(int j = Math.min(n - 1, arr[i].deadline - 1); j >= 0; j--){
                if(!occupied[j]){
                    occupied[j] = true;
                    ++res[0];
                    res[1] += arr[i].profit;
                    break;
                }
            }
        }
        return res;
    }
    // Sort jobs in increasing order of their deadlines
    // Use a maxheap with profit of job as priority
    // Traverse jobs in reverse order (ie deadlines keep on decreasing)
    // Slots available will be from deadline of current index to deadline of previous index
    // For every slot available, poll an element and assign it a slot
    int[] JobSchedulingPQ(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job j1, Job j2){
                return j1.deadline - j2.deadline;
            }    
        });
        int[] res = new int[]{0, 0};
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {return b.profit - a.profit;});
        for(int i = n - 1; i >= 0; i--){
            int slot_available;
            if(i == 0)
                slot_available = arr[i].deadline;
            else
                slot_available = arr[i].deadline - arr[i - 1].deadline;
            pq.add(arr[i]);
            while(slot_available > 0 && !pq.isEmpty()){
                Job j = pq.poll();
                ++res[0];
                res[1] += j.profit;
                slot_available--;
            }
        }
        return res;
    }
}
