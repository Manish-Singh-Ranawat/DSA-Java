
// Union of Two Sorted Arrays - https://www.naukri.com/code360/problems/sorted-array_6613259

// Given two sorted arrays, ‘a’ and ‘b’, of size ‘n’ and ‘m’, respectively, return the union of the arrays.

// The union of two sorted arrays can be defined as an array consisting of the common and the distinct elements of the two arrays. The final array should be sorted in ascending order.

// Note: 'a' and 'b' may contain duplicate elements, but the union array must contain unique elements.

// Input: ‘n’ = 5 ‘m’ = 3
// ‘a’ = [1, 2, 3, 4, 6]
// ‘b’ = [2, 3, 5]

// Output: [1, 2, 3, 4, 5, 6]

// Explanation: Common elements in ‘a’ and ‘b’ are: [2, 3]
// Distinct elements in ‘a’ are: [1, 4, 6]
// Distinct elements in ‘b’ are: [5]
// Union of ‘a’ and ‘b’ is: [1, 2, 3, 4, 5, 6]

import java.util.ArrayList;

public class UnionOfArrays {

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<Integer>();
        int m = a.length;
        int n = b.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || a[i] != union.get(union.size() - 1)) {
                    union.add(a[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || b[j] != union.get(union.size() - 1)) {
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i < m) {
            if (union.size() == 0 || a[i] != union.get(union.size() - 1)) {
                union.add(a[i]);
            }
            i++;
        }

        while (j < n) {
            if (union.size() == 0 || b[j] != union.get(union.size() - 1)) {
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 6 };
        int b[] = { 2, 3, 5 };
        ArrayList<Integer> union = findUnion(a, b);
        System.out.println(union);
        // [1, 2, 3, 4, 5, 6]
    }
}
