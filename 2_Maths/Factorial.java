// Factorial - https://www.naukri.com/code360/problems/factorial_975273

// Given a positive integer, n. Find the factorial of n.
 
// Input: n = 5
// Output: 120
// Explanation: 5*4*3*2*1 = 120

import java.math.BigInteger;

public class Factorial {
    public static void factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        System.out.println(fact);
    }
    public static void main(String[] args) {
        int n = 5;
        factorial(n);
        // 120
    }
}
