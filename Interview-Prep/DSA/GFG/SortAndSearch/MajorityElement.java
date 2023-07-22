package SortAndSearch;
import java.util.Map;
import java.util.HashMap;

public class MajorityElement {
    // Bruteforce approach
    // TC: May be O(NlogN) depending on how the hashmap is implemented
    // SC: O(N)
    static int majorityElementBruteForce(int a[], int size) {
        int max = 0;
        int element = a[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            if (map.containsKey(i)) {
                int currFreq = map.get(i);
                map.put(i, currFreq + 1);
                if (currFreq + 1 > max) {
                    max = currFreq;
                    element = i;
                }
            } else {
                map.put(i, 1);
            }
        }
        if (max >= size / 2)
            return element;
        return -1;
    }
    // Optimized Approach
    // TC: O(N)
    // SC: O(1)
    // Majority element occurs more than N/2 times
    // We increase count whenever we majority element is encountered and decrease it when it is not
    // Count of majority elements will cancel out count of minority elements and we will be left only with extra majority elements
    // However for this it must be guarenteed that majority element is present 
    static int majorityElement(int a[], int size) {
        // your code here
        int count = 0;
        int candidate = 0;
        for (int num : a) {
            if (count == 0)
                candidate = num;
            if (num == candidate)
                count++;
            else
                count--;
        }

        return candidate;
    }
}
