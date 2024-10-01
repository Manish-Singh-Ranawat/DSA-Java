// Kth Missing Positive Number - https://leetcode.com/problems/kth-missing-positive-number/description/

// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
// Return the kth positive integer that is missing from this array.

// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

public class KthMissingPositiveNumber {
    
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        if (k < arr[low]) {
            return k;
        }
        if (k > arr[high] - (high + 1)) {
            return high + 1 + k;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1 + k;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.err.println(findKthPositive(arr, k));
        // 9
    }
}
