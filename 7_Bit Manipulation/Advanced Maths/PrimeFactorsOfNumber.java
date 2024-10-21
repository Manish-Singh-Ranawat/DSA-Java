// Prime Factors of Number - https://www.naukri.com/code360/problems/prime-factorisation_1760849?leftPanelTabValue=PROBLEM

// You are given an integer 'N'.
// You must return the unique prime factors of 'N' in increasing order.

// Input : ‘N’ = 10
// Output : 2, 5
// Explanation : Unique prime factors are 2 and 5. Hence we return {2, 5}.

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsOfNumber {
    public static List<Integer> countPrimes(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                primeFactors.add(i);
                while (n % i == 0) {
                    n = n / i;
                }
            }
        }
        if (n != 1) {
            primeFactors.add(n);
        }
        return primeFactors;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
        // [2, 5]
    }
}
