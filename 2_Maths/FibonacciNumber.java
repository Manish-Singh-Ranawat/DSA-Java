// Fibonacci Number - https://leetcode.com/problems/fibonacci-number/description/

// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
// F(0) = 0, F(1) = 1
// F(n) = F(n - 1) + F(n - 2), for n > 1.
// Given n, calculate F(n).

// Input: n = 4
// Output: 3
// Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

public class FibonacciNumber {
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int secondLast = 0;
        int last = 1;
        int fib = 0;
        for (int i = 1; i < n; i++) {
            fib = secondLast + last;
            secondLast = last;
            last = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
        // 3
    }
}
