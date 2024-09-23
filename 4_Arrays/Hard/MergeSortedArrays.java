// Merge Two Sorted Arrays Without Extra Space - https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839?

// Given two non-decreasing sorted arrays, ‘A’ and ‘B’, having ‘N’ and ‘M’ elements, respectively.
// You must merge these arrays, ‘A’ and ‘B’, into a sorted array without using extra space. Of all the 'N + M' sorted elements, array 'A' should contain the first 'N' elements, and array 'B' should have the last 'M' elements.

// Note:
// You must perform the merge operation in place and must not allocate any extra space to merge the two arrays.

// When ‘N’ = 4, ‘A’ = {1, 4, 5, 7} and ‘M’ = 3, ‘B’ = {2, 3, 6}. 
// We can merge these two arrays into {1, 2, 3, 4, 5, 6, 7} (The elements of ‘A’ are {1, 2, 3, 4} ).
// Hence, the answer is {1, 2, 3, 4, 5, 6, 7}.

import java.util.Arrays;

public class MergeSortedArrays {

    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
        int i = a.length - 1;
        int j = 0;
        while (i >= 0 && j < b.length) {
            if (a[i] > b[j]) {
                long temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void print(long arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long a[] = { 1, 4, 5, 7 };
        long b[] = { 2, 3, 6 };
        mergeTwoSortedArraysWithoutExtraSpace(a, b);
        print(a); // 1 2 3 4
        print(b); // 5 6 7
    }
}
