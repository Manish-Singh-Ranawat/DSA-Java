// Rotting Oranges -  https://leetcode.com/problems/rotting-oranges/description/

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1)
                    freshCount++;
            }
        }
        int maxTime = 0;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int row = cur.row + delRow[k];
                int col = cur.col + delCol[k];
                int time = cur.time;
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && grid[row][col] == 1) {
                    visited[row][col] = true;
                    q.offer(new Pair(row, col, time + 1));
                    freshCount--;
                }
                maxTime = Math.max(time, maxTime);
            }
        }
        return freshCount == 0 ? maxTime : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(grid));
        // 4
    }
}
