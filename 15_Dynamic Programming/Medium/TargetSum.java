// Target Sum - https://leetcode.com/problems/target-sum/description/

// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++)
            totalSum += nums[i];
        if (totalSum - target < 0 || (totalSum - target) % 2 == 1)
            return 0;
        return countSubsetsWithSumK(nums, (totalSum - target) / 2);
    }

    private static int countSubsetsWithSumK(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        if (nums[0] == 0)
            dp[0] = 2;
        else
            dp[0] = 1;
        if (nums[0] != 0 && nums[0] <= target)
            dp[nums[0]] = 1;
        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[target + 1];
            for (int T = 0; T <= target; T++) {
                int notPick = dp[T];
                int pick = T >= nums[idx] ? dp[T - nums[idx]] : 0;
                temp[T] = (notPick + pick);
            }
            dp = temp;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
        // 5
    }
}
