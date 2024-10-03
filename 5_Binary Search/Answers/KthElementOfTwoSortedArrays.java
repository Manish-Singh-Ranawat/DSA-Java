// K-th Element of Two Sorted Arrays - https://www.naukri.com/code360/problems/k-th-element-of-2-sorted-array_1164159

// You're given two sorted arrays 'arr1' and 'arr2' of size 'n' and 'm' respectively and an element 'k'.
// Find the element that would be at the 'kth' position of the combined sorted array.
// Position 'k' is given according to 1 - based indexing, but arrays 'arr1' and 'arr2' are using 0 - based indexing.

// Input: 'arr1' = [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
// Output: 6
// Explanation: The merged array will be [2, 3, 4, 6, 7, 8, 45]. The element at position '4' of this array is 6. Hence we return 6.

import java.util.ArrayList;
import java.util.Arrays;

public class KthElementOfTwoSortedArrays {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if (n > m)
            return kthElement(arr2, arr1, m, n, k);
        int nLeft = k;
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = nLeft - mid1;
            int l1 = (mid1 > 0) ? arr1.get(mid1 - 1) : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2.get(mid2 - 1) : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? arr1.get(mid1) : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? arr2.get(mid2) : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int k = 4;
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2, 3, 45));
        int n = arr1.size();
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 6, 7, 8));
        int m = arr2.size();
        System.out.println(kthElement(arr1, arr2, n, m, k));
        // 6
    }
}
