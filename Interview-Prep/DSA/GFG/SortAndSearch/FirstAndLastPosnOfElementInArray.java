package SortAndSearch;
import java.util.ArrayList;
/*
 * First Attempt: Bruteforce Approach Correct
 */
public class FirstAndLastPosnOfElementInArray {
    // Bruteforce Approach
    // Linear Search
    // Time Complexity O(n)
    ArrayList<Long> findBruteForce(long arr[], int n, int x) {
        // code here
        ArrayList<Long> res = new ArrayList<>();
        int count = 0;
        Long l = Long.valueOf(x);
        for (int i = 0; i < n; i++) {
            if (arr[i] == l) {
                if (count > 1)
                    res.remove(1);
                res.add(Long.valueOf(i));
                ++count;
            } else if (count > 0)
                break;
        }
        if (count == 1)
            res.add(res.get(0));
        if (count == 0) {
            res.add(-1L);
            res.add(-1L);
        }
        return res;
    }

    // Optimized Approach
    // Binary Search
    ArrayList<Long> findOptimized(long arr[], int n, int x) {
        int s = 0;
        int e = n - 1;
        long mid = 0;
        ArrayList<Long> list = new ArrayList<>();
        list.add(-1L);
        list.add(-1L);
        while (s <= e) {
            mid = (s + e) / 2;
            if (x < arr[(int) mid])
                e = (int) mid - 1;
            else if (x > arr[(int) mid])
                s = (int) mid + 1;
            else {
                list.set(0, mid);
                list.set(1, mid);
                break;
            }
        }
        long temp = mid;
        if (list.get(0) != -1) {
            while (temp >= 0 && arr[(int) temp] == x) {
                list.set(0, temp);
                temp--;
            }
            temp = mid;
            while (temp < n && arr[(int) temp] == x) {
                list.set(1, temp);
                temp++;
            }
        }
        return list;
    }
}