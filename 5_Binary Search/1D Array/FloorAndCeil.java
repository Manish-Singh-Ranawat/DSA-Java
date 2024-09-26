// Floor And Ceil - https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401

// You're given a sorted array 'a' of 'n' integers and an integer 'x'.
// Find the floor and ceiling of 'x' in 'a[0..n-1]'.

// Note:
// Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
// Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.

// Input: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Output: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

public class FloorAndCeil {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int floor = -1;
        int ceil = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == x) {
                return new int[] { a[mid], a[mid] };
            } else if (a[mid] > x) {
                ceil = a[mid];
                high = mid - 1;
            } else {
                floor = a[mid];
                low = mid + 1;
            }
        }
        return new int[] { floor, ceil };
    }

    public static void main(String[] args) {
        int a[] = { 3, 4, 4, 7, 8, 10 };
        int x = 5;
        int n = a.length;
        int result[] = getFloorAndCeil(a, n, x);
        System.out.println(result[0] + " " + result[1]);
        // 4 7
    }
}
