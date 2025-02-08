// Count Good Numbers - https://leetcode.com/problems/count-good-numbers/description/

// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

public class CountGoodNumbers {
    private static int mod = (int) 1e9 + 7;

    public static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;
        long a = calcPow(4, odd) % mod;
        long b = calcPow(5, even) % mod;
        return (int) ((a * b) % mod);
    }

    private static long calcPow(long x, long n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        long half = calcPow(x, n / 2);
        long res = (half * half) % mod;
        return (n % 2 == 0) ? res : (res * x) % mod;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countGoodNumbers(n));
        // 5
    }
}
