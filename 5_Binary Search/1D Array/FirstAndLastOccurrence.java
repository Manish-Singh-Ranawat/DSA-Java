// Find First and Last Position of Element in Sorted Array - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

public class FirstAndLastOccurrence {

    public static int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = lastOccurrence(nums, target);
        return new int[] { first, last };
    }

    public static int firstOccurrence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                idx = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static int lastOccurrence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                idx = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int result[] = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
        // 3 4
    }
}
