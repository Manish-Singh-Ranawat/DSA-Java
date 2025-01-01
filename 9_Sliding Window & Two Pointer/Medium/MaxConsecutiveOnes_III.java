// Max Consecutive Ones III - https://leetcode.com/problems/max-consecutive-ones-iii/description/

// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,"1",1,1,1,1,"1"]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

public class MaxConsecutiveOnes_III {
    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int zeroes = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r < n) {
            if (nums[r] == 0) {
                zeroes++;
            }
            if (zeroes > k) {
                if (nums[l] == 0) {
                    zeroes--;
                }
                l++;
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
        // 6
    }
}
