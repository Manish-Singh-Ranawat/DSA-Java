// Rat in a Maze Problem - https://www.naukri.com/code360/problems/rat-in-a-maze_1215030?leftPanelTabValue=PROBLEM

// Consider a rat placed at position (0, 0) in an n x n square matrix mat. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

// The matrix contains only two possible values:
// 0: A blocked cell through which the rat cannot travel.
// 1: A free cell that the rat can pass through.

// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list.+

// The task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.

// Return the final result vector in lexicographically smallest order.

// Input: n = 4, mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
// Output: ["DDRDRR", "DRDDRR"]
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

import java.util.ArrayList;

public class RatInAMaze {
    public static ArrayList<String> findPath(int[][] mat, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0)
            return ans;
        int[][] directions = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        solve(0, 0, n, mat, visited, directions, "", ans);
        return ans;
    }

    private static void solve(int row, int col, int n, int[][] mat, boolean[][] visited, int[][] directions,
            String move, ArrayList<String> ans) {
        if (row == n - 1 && col == n - 1) {
            ans.add(new String(move));
            return;
        }
        String s = "DLRU";
        for (int i = 0; i < 4; i++) {
            int nr = row + directions[i][0];
            int nc = col + directions[i][1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && mat[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                solve(nr, nc, n, mat, visited, directions, move + s.charAt(i), ans);
                visited[nr][nc] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] mat = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        System.out.println(findPath(mat, n));
        // [DDRDRR, DRDDRR]
    }
}
