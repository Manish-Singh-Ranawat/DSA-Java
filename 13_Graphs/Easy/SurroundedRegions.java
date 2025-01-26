// Surrounded Regions - https://leetcode.com/problems/surrounded-regions/

// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation:
// ["X","X","X","X"]         ["X","X","X","X"]
// ["X","O","O","X"]    ->   ["X","X","X","X"]
// ["X","X","O","X"]         ["X","X","X","X"] 
// ["X","O","X","X"]         ["X","O","X","X"]
// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

import java.util.Arrays;

public class SurroundedRegions {
    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, visited, delRow, delCol);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, visited, delRow, delCol);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, visited, delRow, delCol);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, visited, delRow, delCol);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int row, int col, char[][] board, boolean[][] visited, int delRow[], int[] delCol) {
        int m = board.length;
        int n = board[0].length;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !visited[nRow][nCol] && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, board, visited, delRow, delCol);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.print(Arrays.toString(board[i]) + " ");
        }
        // [X, X, X, X] [X, X, X, X] [X, X, X, X] [X, O, X, X]
    }
}
