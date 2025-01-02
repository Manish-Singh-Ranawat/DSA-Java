// Count Number of Nice Subarrays - https://leetcode.com/problems/count-number-of-nice-subarrays/description/

// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

public class CountNumberOfNiceSubArrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int totalSubArrays = countSubarraysWithAtMostKOdds(nums, k) - countSubarraysWithAtMostKOdds(nums, k - 1);
        return totalSubArrays;
    }

    public static int countSubarraysWithAtMostKOdds(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int n = nums.length;
        int oddCount = 0;
        int subArraysCount = 0;
        while (r < n) {
            oddCount += nums[r] % 2;
            while (oddCount > k && l <= r) {
                oddCount -= nums[l] % 2;
                l++;
            }
            if (oddCount <= k) {
                subArraysCount += r - l + 1;
            }
            r++;
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
        // 2
    }
}
