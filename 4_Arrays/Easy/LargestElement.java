// Largest Element in Array - https://www.naukri.com/code360/problems/largest-element-in-the-array-largest-element-in-the-array_5026279

// Given an array, arr. The task is to find the largest element in it.

// Input: arr = [1, 8, 7, 56, 90]
// Output: 90
// Explanation: The largest element of the given array is 90.

public class LargestElement {
    public static int largestElement(int arr[], int n) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]);
        }
        return largest;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 45, 7, 2, -10, 12, 95, 3 };
        int n = arr.length;
        System.out.println(largestElement(arr, n));
        // 95
    }
}
