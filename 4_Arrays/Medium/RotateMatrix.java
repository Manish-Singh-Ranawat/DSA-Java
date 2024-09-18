// Rotate Image - https://leetcode.com/problems/rotate-image/description/

// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Input: matrix = [[1,2,3],
//                  [4,5,6],
//                  [7,8,9]]
// Output: [[7,4,1],
//         [8,5,2],
//         [9,6,3]]

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    public static void reverseRow(int row[]) {
        int low = 0;
        int high = row.length - 1;
        while (low < high) {
            int temp = row[low];
            row[low] = row[high];
            row[high] = temp;
            low++;
            high--;
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
        int matrix[][] = { { 1, 2, 3 },
                           { 4, 5, 6 },
                           { 7, 8, 9 } };
        rotate(matrix);
        printMatrix(matrix);
        //{ { 7, 4, 1 },
        //  { 8, 5, 2 },
        //  { 9, 6, 3 } };
    }
}
