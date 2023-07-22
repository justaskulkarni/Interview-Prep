package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {
    class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
    // Recursive Approach
    int maxChainLength(Pair arr[], int n) {
        Arrays.sort(arr, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.y - b.y;
            }
        });
        return helper(arr, 0, new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    public int helper(Pair arr[], int ind, Pair prev) {
        if (ind == arr.length)
            return 0;
        int Take = Integer.MIN_VALUE;
        if (arr[ind].x > prev.y)
            Take = 1 + helper(arr, ind + 1, arr[ind]);
        int notTake = helper(arr, ind + 1, prev);
        return Math.max(Take, notTake);
    }
}
