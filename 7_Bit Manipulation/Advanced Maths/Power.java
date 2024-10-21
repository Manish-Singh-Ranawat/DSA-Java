// Pow(x, n) - https://leetcode.com/problems/powx-n/description/

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Input: x = 2.00000, n = 10
// Output: 1024.00000

public class Power {
    public static double myPow(double x, int n) {
        double ans = 1;
        boolean isNegative = n < 0;
        long N = Math.abs((long) n);
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
                N--;
            } else {
                x *= x;
                N = N / 2;
            }
        }
        return isNegative ? 1 / ans : ans;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
        // 1024.0
    }
}
