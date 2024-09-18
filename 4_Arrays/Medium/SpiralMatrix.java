// Spiral Matrix - https://leetcode.com/problems/spiral-matrix/description/

// Given an m x n matrix, return all elements of the matrix in spiral order.

// Input: matrix = [[1,2,3,4],
//                  [5,6,7,8],
//                  [9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> spiral = new ArrayList<Integer>();

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                spiral.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiral.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    spiral.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
        }
        return spiral;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
        System.out.println(spiralOrder(matrix));
        // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }

}
