// Swap Two Numbers - https://www.naukri.com/code360/problems/swap-two-numbers_1112577

// You are given two numbers 'a' and 'b' as input.
// You must swap the values of 'a' and 'b' without using a third variable.

// Input: 'a' = 8, 'b' = 5
// Output: 5 8
// Explanation: Initially, the value of 'a' and 'b' is 8 and 5, respectively.
// After swapping, the value of 'a' is 5, and the value of 'b' is 8.

public class SwapTwoNumbers {
    public static void swapNumber(int[] a, int[] b) {
        a[0] = a[0] ^ b[0];
        b[0] = a[0] ^ b[0];
        a[0] = a[0] ^ b[0];
    }

    public static void main(String[] args) {
        int a[] = { 8 };
        int b[] = { 5 };
        swapNumber(a, b);
        System.err.println(a[0] + " " + b[0]);
        // 5 8
    }
}
