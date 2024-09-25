// Implement Upper Bound - https://www.naukri.com/code360/problems/implement-upper-bound_8165383

// You are given a sorted array ‘arr’ containing ‘n’ integers and an integer ‘x’.Implement the ‘upper bound’ function to find the index of the upper bound of 'x' in the array.

// Note:
// 1. The upper bound in a sorted array is the index of the first value that is greater than a given value. 
// 2. If the greater value does not exist then the answer is 'n', Where 'n' is the size of the array.
// 3. Try to write a solution that runs in log(n) time complexity.

// Input: arr[] = {3,5,8,9,15,19}, x = 9
// Output: 4
// Explanation: Index 4 is the smallest index such that arr[4] > x.

public class UpperBound {
    public static int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        int idx = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 9, 15, 19 };
        int x = 9;
        int n = arr.length;
        System.out.println(upperBound(arr, x, n));
        // 4
    }
}
