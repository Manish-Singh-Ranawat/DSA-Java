// Jump Game - https://leetcode.com/problems/jump-game/description/

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxIdx) {
                return false;
            }
            maxIdx = Math.max(maxIdx, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
        // true
    }
}
