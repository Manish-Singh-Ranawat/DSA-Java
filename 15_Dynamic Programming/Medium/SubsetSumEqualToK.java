// Subset Sum Equal To K - https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954?

// You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

// Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

// Input : n = 4, k = 5, arr = [4, 3, 2, 1]
// Output : true
// Explanation : There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.

import java.util.Arrays;

public class SubsetSumEqualToK {
    // -- Tabulation with Space Optimization --
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        if (k == 0)
            return true;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        if (arr[0] <= k)
            dp[arr[0]] = true;
        for (int idx = 1; idx < n; idx++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[target];
                boolean take = target >= arr[idx] ? dp[target - arr[idx]] : false;
                temp[target] = take || notTake;
            }
            dp = temp;
        }
        return dp[k];
    }

    // -- Memoization --
    // public static boolean subsetSumToK(int n, int k, int arr[]) {
    //     int[][] dp = new int[n][k + 1];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return k == 0 ? true : isSubsetPresent(n - 1, k, arr, dp);
    // }

    // private static boolean isSubsetPresent(int idx, int target, int[] arr, int[][] dp) {
    //     if (target == 0)
    //         return true;
    //     if (idx == 0)
    //         return target == arr[0];
    //     if (dp[idx][target] != -1)
    //         return dp[idx][target] == 1;
    //     boolean notTake = isSubsetPresent(idx - 1, target, arr, dp);
    //     boolean take = target >= arr[idx] ? isSubsetPresent(idx - 1, target - arr[idx], arr, dp) : false;
    //     dp[idx][target] = take || notTake ? 1 : 0;
    //     return take || notTake;
    // }

    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(subsetSumToK(n, k, arr));
        // true
    }
}
