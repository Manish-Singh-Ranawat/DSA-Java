// Divide Two Integers - https://leetcode.com/problems/divide-two-integers/description/

// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

// The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

// Return the quotient after dividing dividend by divisor.

// Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

// Input: dividend = 10, divisor = 3
// Output: 3
// Explanation: 10/3 = 3.33333.. which is truncated to 3.

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == divisor) {
            return 1;
        }
        boolean sign = true;
        if (dividend < 0 && divisor > 0) {
            sign = false;
        }
        if (dividend > 0 && divisor < 0) {
            sign = false;
        }
        long numerator = Math.abs((long) dividend);
        long denominator = Math.abs((long) divisor);
        long quotient = 0;
        while (numerator >= denominator) {
            int count = 0;
            while (numerator >= denominator << (count + 1)) {
                count++;
            }
            quotient += (1L << count);
            numerator -= (denominator << count);
        }
        quotient = sign ? quotient : -quotient;
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) quotient;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
        // 3
    }
}
