// Split Array Largest Sum - https://leetcode.com/problems/split-array-largest-sum/description/

// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            return -1;
        }
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countSubArrays(nums, n, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countSubArrays(int[] nums, int n, int maxSum) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                sum = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(nums, k));
        // 18
    }
}