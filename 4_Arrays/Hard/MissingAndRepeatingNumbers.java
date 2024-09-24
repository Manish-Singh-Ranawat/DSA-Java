// Missing And Repeating Numbers - https://www.naukri.com/code360/problems/missing-and-repeating-numbers_6828164?

// You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’. Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.

// Input : array[] = {3,1,2,5,4,6,7,5}
// Result : (5,8)
// Explanation : Since 5 is appearing twice and 8 is missing

public class MissingAndRepeatingNumbers {

    public static int[] findMissingRepeatingNumbers(int[] a) {
        long n = a.length;
        long sumOfNum = (n * (n + 1)) / 2;
        long sumOfSquareOfNum = (n * (n + 1) * (2 * n + 1)) / 6;
        long sumOfArr = 0;
        long sumOfSquareOfArr = 0;
        for (int i = 0; i < n; i++) {
            sumOfArr += (long) a[i];
            sumOfSquareOfArr += (long) a[i] * (long) a[i];
        }
        long exp1 = sumOfArr - sumOfNum;
        long exp2 = sumOfSquareOfArr - sumOfSquareOfNum;
        exp2 = exp2 / exp1;
        long repeating = (exp2 + exp1) / 2;
        long missing = exp2 - repeating;
        return new int[] { (int) repeating, (int) missing };
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = { 3, 1, 2, 5, 4, 6, 7, 5 };
        int ans[] = findMissingRepeatingNumbers(a);
        print(ans);
        // 5 8
    }
}
