// Prime Number - https://www.naukri.com/code360/problems/check-prime_624934

// A prime number is a positive integer that is divisible by exactly 2 integers, 1 and the number itself.

// You are given a number 'n'.
// Find out whether 'n' is prime or not.

// Input: 'n' = 5
// Output: YES
// Explanation: 5 is only divisible by 1 and 5. 2, 3 and 4 do not divide 5.

public class PrimeNumber {
    public static String isPrime(int num) {
        if (num < 2) {
            return "NO";
        }
        if (num == 2 || num == 3) {
            return "YES";
        }
        if (num % 2 == 0) {
            return "NO";
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(isPrime(num));
        // YES
    }
}
