// Find a Peak Element II - https://leetcode.com/problems/find-a-peak-element-ii/description/

// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

// Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
// Output: [1,1]
// Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.

public class PeakElement_II {
    public static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int max = Integer.MIN_VALUE;
            int row = -1;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > max) {
                    max = mat[i][mid];
                    row = i;
                }
            }
            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : -1;
            int right = (mid + 1 < n) ? mat[row][mid + 1] : -1;
            if (max > left && max > right) {
                return new int[] { row, mid };
            } else if (max < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[][] mat = { { 10, 20, 15 },
                        { 21, 30, 14 },
                        { 7, 16, 32 } };
        int[] ans = findPeakGrid(mat);
        System.out.print(ans[0] + " " + ans[1]);
        // 1 1
    }
}
