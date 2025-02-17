// House Robber II - https://leetcode.com/problems/house-robber-ii/description/

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

public class HouseRobber_II {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int leavingFirstIndex = helper(1, n - 1, nums);
        int leavingLastIndex = helper(0, n - 2, nums);
        return Math.max(leavingFirstIndex, leavingLastIndex);
    }

    private static int helper(int start, int end, int[] nums) {
        int prev2 = 0;
        int prev = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int pick = prev2 + nums[i];
            int notPick = prev;
            int cur = Math.max(pick, notPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
        // 4
    }
}
