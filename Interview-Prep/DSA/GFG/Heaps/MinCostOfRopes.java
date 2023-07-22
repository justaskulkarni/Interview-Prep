package Heaps;
import java.util.PriorityQueue;
/*
 * First Attempt: Approach did strike, wasn't really aware of Priority Queue methods
 */
public class MinCostOfRopes {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ans = 0;
        for (int i = 0; i < n; i++)
            pq.add(arr[i]);
        while (pq.size() != 1) {
            long a = pq.poll();
            long b = pq.poll();
            ans += a + b;
            pq.add(a + b);
        }
        return ans;
    }    
}
