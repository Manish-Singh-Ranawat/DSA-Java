// Set Matrix Zeroes - https://leetcode.com/problems/set-matrix-zeroes/description/

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Input: matrix = [[1,1,1],
//                  [1,0,1],
//                  [1,1,1]]
// Output:[[1,0,1],
//         [0,0,0],
//         [1,0,1]]

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 1, 1 }, 
                           { 1, 0, 1 }, 
                           { 1, 1, 1 } };
        setZeroes(matrix);
        printMatrix(matrix);
        // { { 1, 0, 1},
        //   { 0, 0, 0},
        //   { 1, 0, 1} }
    }
}
