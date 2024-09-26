// Number of occurrence - https://www.naukri.com/code360/problems/occurrence-of-x-in-a-sorted-array_630456

// You have been given a sorted array/list of integers 'arr' of size 'n' and an integer 'x'.
// Find the total number of occurrences of 'x' in the array/list.

// Input: 'n' = 7, 'x' = 3 , 'arr' = [1, 1, 1, 2, 2, 3, 3]
// Output: 2
// Explanation: Total occurrences of '3' in the array 'arr' is 2.

public class CountOccurrence {

    public static int count(int arr[], int n, int x) {
        int first = firstOccurrence(arr, n, x);
        if (first == -1) {
            return 0;
        }
        int last = lastOccurrence(arr, n, x);
        return (last - first + 1);
    }

    public static int firstOccurrence(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                idx = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static int lastOccurrence(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                idx = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2, 3, 3 };
        int n = arr.length;
        int x = 3;
        System.out.println(count(arr, n, x));
        // 2
    }
}
