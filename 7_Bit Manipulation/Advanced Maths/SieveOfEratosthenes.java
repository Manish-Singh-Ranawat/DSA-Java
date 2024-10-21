// Count Primes - https://leetcode.com/problems/count-primes/

// Given an integer n, return the number of prime numbers that are strictly less than n.

// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

public class SieveOfEratosthenes {

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean isPrime[] = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
