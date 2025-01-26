// 01 Matrix - https://leetcode.com/problems/01-matrix/description/

// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

// The distance between two cells sharing a common edge is 1.

// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int steps;

    Pair(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int steps = cur.steps;
            dist[row][col] = steps;
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && mat[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    q.offer(new Pair(nRow, nCol, steps + 1));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] res = updateMatrix(mat);
        for (int i = 0; i < res.length; i++) {
            System.out.print(Arrays.toString(res[i]) + " ");
        }
        // [0, 0, 0] [0, 1, 0] [1, 2, 1]
    }
}
