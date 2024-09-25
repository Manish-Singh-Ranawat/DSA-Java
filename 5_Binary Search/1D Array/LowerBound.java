// Implement Lower Bound - https://www.naukri.com/code360/problems/lower-bound_8165382
// You are given an array 'arr' sorted in non-decreasing order and a number 'x'. You must return the index of the lower bound of 'x'.

// Note:
// 1. For a sorted array 'arr', 'lower_bound' of a number 'x' is defined as the smallest index 'idx' such that the value 'arr[idx] >= x'.
// 2. If all numbers are smaller than 'x', then 'n' should be the 'lower_bound' of 'x', where 'n' is the size of array.
// 3. Try to do this in O(log(n)).

// Input: arr[] = {3,5,8,15,19}, x = 9
// Output: 3
// Explanation: Index 3 is the smallest index such that arr[3] >= x.

public class LowerBound {
    public static int lowerBound(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        int idx = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 15, 19 };
        int x = 9;
        int n = arr.length;
        System.out.println(lowerBound(arr, n, x));
        // 3
    }
}
