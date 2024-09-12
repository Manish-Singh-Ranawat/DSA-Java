// Check Sorted Array - https://www.naukri.com/code360/problems/ninja-and-the-sorted-check_6581957

// You have been given an array ‘a’ of ‘n’ non-negative integers.You have to check whether the given array is sorted in the non-decreasing order or not.

// Your task is to return 1 if the given array is sorted. Else, return 0.

// Input: ‘n’ = 5, ‘a’ = [1, 2, 3, 4, 5]
// Output: 1
// The given array is sorted in non-decreasing order; hence the answer will be 1.

public class CheckSorted {
    public static int isSorted(int a[], int n) {
        for (int i = 0; i < n -1; i++) {
            if (a[i] > a[i+1]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int n = a.length;
        System.out.println(isSorted(a, n));
        // 1
    }
}
