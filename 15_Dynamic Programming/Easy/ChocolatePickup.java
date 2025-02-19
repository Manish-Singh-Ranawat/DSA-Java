// Chocolate Pickup - https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885?

// Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.

// Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell, only one of them will pick the chocolates in it.

// If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.

// Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.

// Input: m = 3, n = 4, grid = [[2, 3, 1, 2], [3, 4, 2, 2], [5, 6, 3, 5]]
// Output: 21
// Explanation :
// Initially Alice is at the position (0,0) he can follow the path (0,0) -> (1,1) -> (2,1) and will collect 2 + 4 + 6 = 12 chocolates.

// Initially Bob is at the position (0, 3) and he can follow the path (0, 3) -> (1,3) -> (2, 3) and will collect 2 + 2 + 5 = 9 chocolates.

// Hence the total number of chocolates collected will be 12 + 9 = 21. there is no other possible way to collect a greater number of chocolates than 21.

import java.util.Arrays;

public class ChocolatePickup {
    // -- Tabulation with Space Optimization --
    public static int maximumChocolates(int m, int n, int[][] grid) {
        int[][] dp = new int[n][n];
        for (int ja = 0; ja < n; ja++) {
            for (int jb = 0; jb < n; jb++) {
                dp[ja][jb] = ja == jb ? grid[m - 1][ja] : grid[m - 1][ja] + grid[m - 1][jb];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            int[][] temp = new int[n][n];
            for (int ja = 0; ja < n; ja++) {
                for (int jb = 0; jb < n; jb++) {
                    int max = Integer.MIN_VALUE;
                    for (int dja = -1; dja <= 1; dja++) {
                        for (int djb = -1; djb <= 1; djb++) {
                            int val = ja == jb ? grid[i][ja] : grid[i][ja] + grid[i][jb];
                            if (ja + dja >= 0 && ja + dja < n && jb + djb >= 0 && jb + djb < n)
                                val += dp[ja + dja][jb + djb];
                            max = Math.max(max, val);
                        }
                    }
                    temp[ja][jb] = max;
                }
            }
            dp = temp;
        }
        return dp[0][n - 1];
    }

    // -- Memoization --
    // public static int maximumChocolates(int m, int n, int[][] grid) {
    //     int[][][] dp = new int[m][n][n];
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             Arrays.fill(dp[i][j], -1);
    //         }
    //     }
    //     return helper(0, 0, n - 1, m, n, grid, dp);
    // }

    // private static int helper(int i, int ja, int jb, int m, int n, int[][] grid, int[][][] dp) {
    //     if (ja < 0 || ja >= n || jb < 0 || jb >= n)
    //         return (int) -1e9;
    //     if (i == m - 1) {
    //         return ja == jb ? grid[i][ja] : grid[i][ja] + grid[i][jb];
    //     }
    //     if (dp[i][ja][jb] != -1)
    //         return dp[i][ja][jb];
    //     int max = Integer.MIN_VALUE;
    //     for (int dja = -1; dja <= 1; dja++) {
    //         for (int djb = -1; djb <= 1; djb++) {
    //             int val = ja == jb ? grid[i][ja] : grid[i][ja] + grid[i][jb];
    //             val += helper(i + 1, ja + dja, jb + djb, m, n, grid, dp);
    //             max = Math.max(max, val);
    //         }
    //     }
    //     return dp[i][ja][jb] = max;
    // }

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        int[][] grid = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
        System.out.println(maximumChocolates(m, n, grid));
        // 21
    }
}
