// Maximal Rectangle - https://leetcode.com/problems/maximal-rectangle/description/

// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

// Input: matrix = [["1","0","1","0","0"],
//                  ["1","0","1","1","1"],
//                  ["1","1","1","1","1"],
//                  ["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int heights[][] = new int[m][n];
        for (int j = 0; j < n; j++) {
            int h = 0;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '0') {
                    h = 0;
                } else {
                    h++;
                }
                heights[i][j] = h;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i], n));
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights, int n) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height * width);
            }
            stack.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(maximalRectangle(matrix));
        // 6
    }
}