// Word Search - https://leetcode.com/problems/word-search/description/

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    if (solve(i, j, m, n, board, visited, 1, word, directions))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean solve(int row, int col, int m, int n, char[][] board, boolean[][] visited, int idx,
            String word, int[][] directions) {
        if (idx == word.length()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int nr = row + directions[i][0];
            int nc = col + directions[i][1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && board[nr][nc] == word.charAt(idx)) {
                visited[nr][nc] = true;
                if (solve(nr, nc, m, n, board, visited, idx + 1, word, directions))
                    return true;
                visited[nr][nc] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
        // true
    }
}
