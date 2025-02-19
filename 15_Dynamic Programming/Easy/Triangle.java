// Triangle - https://leetcode.com/problems/triangle/description/

// Given a triangle array, return the minimum path sum from top to bottom.

// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    // -- Tabulation with Space Optimization --
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int j = 0; j < n; j++)
            dp[j] = triangle.get(n - 1).get(j);
        for (int i = n - 2; i >= 0; i--) {
            int[] temp = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j + 1];
                temp[j] = Math.min(down, diagonal);
            }
            dp = temp;
        }
        return dp[0];
    }

    // -- Memoization --
    // public static int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
    //     int[][] dp = new int[n][n];
    //     for (int i = 0; i < n; i++)
    //         Arrays.fill(dp[i], -1);
    //     return helper(0, 0, n, triangle, dp);
    // }

    // private static int helper(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
    //     if (i == n - 1)
    //         return triangle.get(n - 1).get(j);
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int down = triangle.get(i).get(j) + helper(i + 1, j, n, triangle, dp);
    //     int diagonal = triangle.get(i).get(j) + helper(i + 1, j + 1, n, triangle, dp);
    //     return dp[i][j] = Math.min(down, diagonal);
    // }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 4)));
        triangle.add(new ArrayList<>(List.of(6, 5, 7)));
        triangle.add(new ArrayList<>(List.of(4, 1, 8, 3)));
        System.out.println(minimumTotal(triangle));
        // 11
    }
}
