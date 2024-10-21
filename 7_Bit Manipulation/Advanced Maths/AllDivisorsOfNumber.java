// Print all Divisors of a number - https://www.naukri.com/code360/problems/print-all-divisors-of-a-number_1164188?leftPanelTabValue=PROBLEM

// Given an integer ‘N’, your task is to write a program that returns all the divisors of ‘N’ in ascending order.

// Input : 10
// Output : 1 2 5 10
// Explanation : The divisors of 10 are 1,2,5,10.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllDivisorsOfNumber {
    public static List<Integer> printDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (n / i != i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    public static void main(String[] args) {
        int n = 10;
        System.err.println(printDivisors(n));
        // [1, 2, 5, 10]
    }
}
