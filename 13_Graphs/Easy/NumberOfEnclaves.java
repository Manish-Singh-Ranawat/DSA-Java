// Number of Enclaves - https://leetcode.com/problems/number-of-enclaves/description/

// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class NumberOfEnclaves {
    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                q.offer(new Pair(0, j));
                visited[0][j] = true;
            }
            if (grid[m - 1][j] == 1) {
                q.offer(new Pair(m - 1, j));
                visited[m - 1][j] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                q.offer(new Pair(i, 0));
                visited[i][0] = true;
            }
            if (grid[i][n - 1] == 1) {
                q.offer(new Pair(i, n - 1));
                visited[i][n - 1] = true;
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol]
                        && grid[nRow][nCol] == 1) {
                    q.offer(new Pair(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(numEnclaves(grid));
        // 3
    }
}
