package SortAndSearch;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * First Attempt: Brute Force Approach Correct
*/
public class FindAllFourSumNumbers {
    // Bruteforce Approach
    // 4 nested for loops
    // TC: O(N^4)
    // Optimized Approach
    // TC: O(N^3)
    // Here, we take advantage of the fact that array is sorted
    // Select two elements and subract them from the sum and update sum variable
    // Now, consider array after second chosen element
    // Now mark start and end index of that array
    // Since array is sorted, if 1. Start and End elements sum up to sum variable then add 4 numbers to arraylist
    //                              Then increment start and decrement end
    //                           2. Start and End elements sum less than sum, increment start
    //                           3. Start and End elements sum less than sum, decrement end
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int sum = k - (arr[i] + arr[j]);
                int start = j + 1;
                int end = arr.length - 1;
                while (start < end) {
                    int t = arr[start] + arr[end];
                    if (t == sum) {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[start], arr[end])));
                        start++;
                        end--;
                    } else if (t < sum)
                        ++start;
                    else
                        --end;
                }
            }
        }
        return res;
    }
}
