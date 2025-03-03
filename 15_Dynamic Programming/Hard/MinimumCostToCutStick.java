// Minimum Cost to Cut a Stick - https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

// Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:

// Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

// You should perform the cuts in order, you can change the order of the cuts as you wish.

// The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.

// Return the minimum total cost of the cuts.

// Input: n = 7, cuts = [1,3,4,5]
// Output: 16
// Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

// The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
// Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).

import java.util.Arrays;

public class MinimumCostToCutStick {
    // -- Tabulation --
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++)
            arr[i + 1] = cuts[i];
        Arrays.sort(arr);
        int[][] dp = new int[m + 2][m + 2];
        for (int i = m; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                if (i > j) continue;
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = arr[j + 1] - arr[i - 1] + dp[i][k-1] 
                            + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][m];
    }

    // -- Memoization --
    // public static int minCost(int n, int[] cuts) {
    //     int m = cuts.length;
    //     int[] arr = new int[m + 2];
    //     arr[0] = 0;
    //     arr[m + 1] = n;
    //     for (int i = 0; i < m; i++)
    //         arr[i + 1] = cuts[i];
    //     Arrays.sort(arr);
    //     int[][] dp = new int[m + 2][m + 2];
    //     for (int i = 0; i < m + 2; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(1, m, arr, dp);
    // }

    // private static int helper(int i, int j, int[] arr, int[][] dp) {
    //     if (i > j)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int min = Integer.MAX_VALUE;
    //     for (int k = i; k <= j; k++) {
    //         int cost = arr[j + 1] - arr[i - 1] + helper(i, k - 1, arr, dp)
    //                 + helper(k + 1, j, arr, dp);
    //         min = Math.min(min, cost);
    //     }
    //     return dp[i][j] = min;
    // }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = { 1, 3, 4, 5 };
        System.out.println(minCost(n, cuts));
        // 16
    }
}
