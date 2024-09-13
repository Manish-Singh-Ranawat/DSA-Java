
// Transpose of a Matrix - https://www.naukri.com/code360/problems/transpose-of-a-matrix_2824817

// You are given a matrix ‘MAT’. Print and return the transpose of the matrix. The transpose of a matrix is obtained by changing rows to columns and columns to rows. In other words, transpose of a matrix A[][] is obtained by changing A[i][j] to A[j][i].

// For example: Let matrix be : 1 2
//                              3 4

// Then transpose of the matrix will be: 1 3
//                                       2 4

public class TransposeOfMatrix {
    public static int[][] transpose(int m, int n, int mat[][]) {
        int transpose[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = mat[i][j];
            }
        }
        return transpose;
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2 },
                           { 3, 4 } };
        int m = matrix.length;
        int n = matrix[0].length;
        int transposedMatrix[][] = transpose(m, n, matrix);
        printMatrix(transposedMatrix);
        // 1 3
        // 2 4
    }
}
