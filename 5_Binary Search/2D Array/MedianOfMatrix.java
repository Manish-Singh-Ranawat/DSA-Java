// Median in a row-wise sorted Matrix - https://www.naukri.com/code360/problems/median-of-a-row-wise-sorted-matrix_1115473

// You are given a row-wise sorted matrix 'mat' of size m x n where 'm' and 'n' are the numbers of rows and columns of the matrix, respectively.

// Your task is to find and return the median of the matrix.

// Note: 'm' and 'n' will always be odd.

// Input: 'n' = 5, 'm' = 5 
// 'mat' = 
// [     [ 1, 5, 7, 9, 11 ],
//       [ 2, 3, 4, 8, 9 ],
//       [ 4, 11, 14, 19, 20 ],
//       [ 6, 10, 22, 99, 100 ],
//       [ 7, 15, 17, 24, 28 ]   ]

// Output: 10

// Explanation: If we arrange the elements of the matrix in the sorted order in an array, they will be like this-
// 1 2 3 4 4 5 6 7 7 8 9 9 10 11 11 14 15 17 19 20 22 24 28 99 100 
// So the median is 10, which is at index 12, which is midway as the total elements are 25, so the 12th index is exactly midway. Therefore, the answer will be 10.

public class MedianOfMatrix {
    public static int findMedian(int matrix[][], int m, int n) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }
        int req = (m * n) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEquals(matrix, m, n, mid);
            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countSmallEquals(int matrix[][], int m, int n, int target) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            count += upperBound(matrix[i], n, target);
        }
        return count;
    }

    public static int upperBound(int row[], int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int mat[][] = { { 1, 5, 7, 9, 11 },
                { 2, 3, 4, 8, 9 },
                { 4, 11, 14, 19, 20 },
                { 6, 10, 22, 99, 100 },
                { 7, 15, 17, 24, 28 } };
        System.out.println(findMedian(mat, m, n));
        // 10
    }
}
