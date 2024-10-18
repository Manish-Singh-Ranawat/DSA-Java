// Power of Two - https://leetcode.com/problems/power-of-two/description/

// Given an integer n, return true if it is a power of two. Otherwise, return false.
// An integer n is a power of two, if there exists an integer x such that n == 2x.

// Input: n = 1
// Output: true
// Explanation: 2^0 = 1

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isPowerOfTwo(1));
        // true
    }
}
