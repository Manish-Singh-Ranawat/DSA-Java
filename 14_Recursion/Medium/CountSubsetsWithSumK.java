// Count Subsets with Sum K - https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532

// You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.

// Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.

// Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

// Input: arr = [1, 1, 4, 5], tar = 5
// Output: 3
// Explanation: The possible ways are: [[1, 4], [1, 4], [5]]
// Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.

public class CountSubsetsWithSumK {
    public static int findWays(int[] arr, int tar) {
        int MOD = 1000000007;
        return subsetSumToK(0, arr.length, arr, tar, 0, MOD);
    }

    private static int subsetSumToK(int i, int n, int[] arr, int tar, int sum, int MOD) {
        if (sum > tar) {
            return 0;
        }
        if (i >= n) {
            return sum == tar ? 1 : 0;
        }
        int include = subsetSumToK(i + 1, n, arr, tar, sum + arr[i], MOD);
        int exclude = subsetSumToK(i + 1, n, arr, tar, sum, MOD);
        return (include + exclude) % MOD;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 4, 5 };
        int tar = 5;
        System.out.println(findWays(arr, tar));
        // 3
    }
}
