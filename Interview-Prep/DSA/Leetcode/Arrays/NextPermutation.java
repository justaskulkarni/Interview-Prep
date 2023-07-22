package DSA.Leetcode.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] arr) {
        int n = arr.length, i, j;

        // Find for the pivot element.
        // A pivot is the first element from
        // end of sequencewhich doesn't follow
        // property of non-increasing suffix
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        // Check if pivot is not found
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
        }

        // if pivot is found
        else {

            // Find for the successor of pivot in suffix
            for (j = n - 1; j > i; j--) {
                if (arr[j] > arr[i]) {
                    break;
                }
            }

            // Swap the pivot and successor
            swap(arr, i, j);

            // Minimise the suffix part
            reverse(arr, i + 1, arr.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
