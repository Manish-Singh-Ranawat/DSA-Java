// Array partition with minimum difference - https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?

// You are given an array 'arr' containing 'n' non-negative integers.

// Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.

// You just need to find the minimum absolute difference considering any valid division of the array elements.

// Note:
// 1. Each array element should belong to exactly one of the subsets.
// 2. Subsets need not always be contiguous.
// 3. Subset-sum is the sum of all the elements in that subset. 

// Input: n = 5, arr = [3, 1, 5, 2, 8].
// Output: 1
// Explanation: We can partition the given array into {3, 1, 5} and {2, 8}. 
// This will give us the minimum possible absolute difference i.e. (10 - 9 = 1).

public class ArrayPartitionWithMinimumDifference {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int i = 0; i < n; i++)
            totalSum += arr[i];
        boolean[] dp = new boolean[totalSum + 1];
        dp[0] = true;
        if (arr[0] <= totalSum)
            dp[arr[0]] = true;
        for (int idx = 1; idx < n; idx++) {
            boolean[] temp = new boolean[totalSum + 1];
            temp[0] = true;
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = dp[target];
                boolean take = target >= arr[idx] ? dp[target - arr[idx]] : false;
                temp[target] = take || notTake;
            }
            dp = temp;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < totalSum + 1; i++) {
            if (dp[i]) {
                min = Math.min(min, Math.abs(i - (totalSum - i)));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 3, 1, 5, 2, 8 };
        System.out.println(minSubsetSumDifference(arr, n));
        // 1
    }
}
