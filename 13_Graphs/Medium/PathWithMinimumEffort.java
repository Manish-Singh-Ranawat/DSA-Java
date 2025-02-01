// Path With Minimum Effort - https://leetcode.com/problems/path-with-minimum-effort/description/

// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

import java.util.Arrays;
import java.util.PriorityQueue;

class Tuple {
    int distance;
    int row;
    int col;

    Tuple(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> q = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        q.offer(new Tuple(0, 0, 0));
        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            Tuple cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int diff = cur.distance;
            if (row == m - 1 && col == n - 1)
                return diff;
            for (int i = 0; i < 4; i++) {
                int nr = row + directions[i][0];
                int nc = col + directions[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newEffort = Math.max(Math.abs(heights[nr][nc] - heights[row][col]), diff);
                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        q.offer(new Tuple(effort[nr][nc], nr, nc));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(minimumEffortPath(heights));
        // 2
    }
}
