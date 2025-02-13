// N-Queens - https://leetcode.com/problems/n-queens/description/

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[2 * n - 1];
        boolean[] lowerDiagonal = new boolean[2 * n - 1];
        List<List<String>> ans = new ArrayList<>();
        solve(0, n, board, leftRow, upperDiagonal, lowerDiagonal, ans);
        return ans;
    }

    private static void solve(int col, int n, char[][] board, boolean[] leftRow, boolean[] lowerDiagonal,
            boolean[] upperDiagonal, List<List<String>> ans) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[n - 1 + col - row]) {
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[n - 1 + col - row] = true;
                solve(col + 1, n, board, leftRow, lowerDiagonal, upperDiagonal, ans);
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagonal[row + col] = false;
                upperDiagonal[n - 1 + col - row] = false;
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
        // [[..Q., Q..., ...Q, .Q..], [.Q.., ...Q, Q..., ..Q.]]
    }
}
