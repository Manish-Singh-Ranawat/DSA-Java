// Distinct Islands - https://www.naukri.com/code360/problems/distinct-island_630460?leftPanelTabValue=PROBLEM

// You are given a two-dimensional array/list of integers consisting of 0s and 1s. In the list, 1 represents land and 0 represents water.

// The task is to find the number of distinct islands where a group of connected 1s(horizontally or vertically) forms an island.

// Note:
// Two islands are considered to be the same if and only if one island is equal to another(not rotated or reflected) i.e if we can translate one island on another without rotating or reflecting then it would be considered as the same islands. 

// Input: m = 4, n = 5, grid = [[ 1, 1, 0, 1, 1 ],
//                              [ 1, 0, 0, 0, 0 ],
//                              [ 0, 0, 0, 0, 1 ],
//                              [ 1, 1, 0, 1, 1 ]]
// Output: 3
// Explanation: Distinct islands in the example above are: 
// 1st -> at the top left corner; 
// 2nd -> at the top right corner  
// 3rd -> at the bottom right corner. 
// We ignore the island at the bottom left corner since it is identical to the top right corner.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return row == pair.row && col == pair.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

public class DistinctIslands {
    public static int distinctIsland(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Set<ArrayList<Pair>> set = new HashSet<>();
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<Pair> list = new ArrayList<>();
                    dfs(i, j, grid, visited, list, i, j, delRow, delCol);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    public static void dfs(int row, int col, int[][] grid, boolean[][] visited, ArrayList<Pair> list, int row0,
            int col0,
            int[] delRow, int[] delCol) {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        list.add(new Pair(row - row0, col - col0));
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, visited, list, row0, col0, delRow, delCol);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } };
        int m = grid.length;
        int n = grid[0].length;
        System.out.println(distinctIsland(grid, m, n));
        // 3
    }

}
