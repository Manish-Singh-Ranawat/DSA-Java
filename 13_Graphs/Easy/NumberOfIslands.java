// Number of Islands - https://leetcode.com/problems/number-of-islands/

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

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

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(new Pair(i, j), visited, grid);
                }
            }
        }
        return count;
    }

    public static void bfs(Pair node, boolean[][] visited, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(node);
        visited[node.row][node.col] = true;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int row = cur.row + delRow[k];
                int col = cur.col + delCol[k];
                if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    q.offer(new Pair(row, col));
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = { 
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(numIslands(grid));
        // 1
    }
}
