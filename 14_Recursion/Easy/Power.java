// Pow(x, n) - https://leetcode.com/problems/powx-n/description/

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Input: x = 2.00000, n = 10
// Output: 1024.00000

public class Power {
    public static double myPow(double x, int n) {
        if (n < 0)
            return (1.0 / calcPow(x, n));
        return calcPow(x, n);
    }
    private static double calcPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double half = calcPow(x, n / 2);
        double res = half * half;
        return (n % 2 == 0) ? res : res * x;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
        // 1024.0
    }
}
