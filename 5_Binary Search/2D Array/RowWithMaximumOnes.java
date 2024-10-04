// Row with max 1s - https://www.naukri.com/code360/problems/row-of-a-matrix-with-maximum-ones_982768

// You are given a 2D matrix 'ARR' (containing either ‘0’ or ‘1’) of size 'N' x 'M', where each row is in sorted order.

// Find the 0-based index of the first row with the maximum number of 1's.

// Note : If two rows have the same number of 1’s, return the row with a lower index.
// If no row exists where at-least one '1' is present, return -1.

// Input: ‘N’ = 3, 'M' = 3, 'ARR' = [ [ 1,  1,  1 ] , [ 0,  0,  1 ] , [ 0,  0,  0 ] ]
// Output: 0
// Explanation: The 0th row of the given matrix has the maximum number of ones.

import java.util.ArrayList;
import java.util.Arrays;

public class RowWithMaximumOnes {
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int idx = -1;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = m - lowerBound(matrix.get(i), m);
            if (count > maxCount) {
                maxCount = count;
                idx = i;
            }
        }
        return idx;
    }

    public static int lowerBound(ArrayList<Integer> row, int m) {
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row.get(mid) >= 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        int n = matrix.size();
        int m = matrix.get(0).size();
        System.out.println(maximumOnesRow(matrix, n, m));
        // 0
    }
}
