// Partitions With Given Difference - https://www.naukri.com/code360/problems/partitions-with-given-difference_3751628?

// Given an array ‘arr’, partition it into two subsets (possibly empty) such that their union is the original array. Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.

// Given a difference ‘d’, count the number of partitions in which ‘S1’ is greater than or equal to ‘S2’ and the difference between ‘S1’ and ‘S2’ is equal to ‘D’. Since the answer may be too large, return it modulo ‘10^9 + 7’.

// If ‘Pi_Sj’ denotes the Subset ‘j’ for Partition ‘i’. Then, two partitions P1 and P2 are considered different if:

// 1) P1_S1 != P2_S1 i.e, at least one of the elements of P1_S1 is different from P2_S2.
// 2) P1_S1 == P2_S2, but the indices set represented by P1_S1 is not equal to the indices set of P2_S2. Here, the indices set of P1_S1 is formed by taking the indices of the elements from which the subset is formed.
// Refer to the example below for clarification.
// Note that the sum of the elements of an empty subset is 0.

// Input : n = 4, d = 3, arr = {5, 2, 5, 1}
// Output :  2
// Explanation :
// There are only two possible partitions of this array.
// Partition 1: {5, 2, 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
// Partition 2: {5, 2, 1}, {5}. The subset difference between subset sum is: (5 + 2 + 1) - (5) = 3
// These two partitions are different because, in the 1st partition, S1 contains 5 from index 0, and in the 2nd partition, S1 contains 5 from index 2.

public class PartitionsWithGivenDifference {
    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < n; i++)
            totalSum += arr[i];
        if (totalSum - d < 0 || (totalSum - d) % 2 == 1)
            return 0;
        return countSubsetsWithSumK(arr, (totalSum - d) / 2);
    }

    private static int countSubsetsWithSumK(int[] nums, int k) {
        int MOD = 1000000007;
        int n = nums.length;
        int[] dp = new int[k + 1];
        if (nums[0] == 0)
            dp[0] = 2;
        else
            dp[0] = 1;
        if (nums[0] != 0 && nums[0] <= k)
            dp[nums[0]] = 1;
        for (int idx = 1; idx < n; idx++) {
            int[] temp = new int[k + 1];
            for (int target = 0; target <= k; target++) {
                int notPick = dp[target];
                int pick = target >= nums[idx] ? dp[target - nums[idx]] : 0;
                temp[target] = (notPick + pick) % MOD;
            }
            dp = temp;
        }
        return dp[k];
    }

    public static void main(String[] args) {
        int n = 4;
        int d = 3;
        int[] arr = { 5, 2, 5, 1 };
        System.out.println(countPartitions(n, d, arr));
        // 2
    }
}
