// Sum of all divisors - https://www.naukri.com/code360/problems/sum-of-all-divisors_8360720

// You are given an integer ‘n’.

// Function ‘sumOfDivisors(n)’ is defined as the sum of all divisors of ‘n’.
// Find the sum of ‘sumOfDivisors(i)’ for all ‘i’ from 1 to ‘n’.

// Input: ‘n’  = 5
// Output: 21
// Explanation: We need to find the sum of ‘sumOfDivisors(i)’ for all ‘i’ from 1 to 5. 
// ‘sumOfDivisors(1)’ = 1
// ‘sumOfDivisors(2)’ = 2 + 1 = 3
// ‘sumOfDivisors(3)’ = 3 + 1 = 4
// ‘sumOfDivisors(4)’ = 4 + 2 + 1 = 7 
// ‘sumOfDivisors(5)’ = 5 + 1 = 6
// Therefore our answer is sumOfDivisors(1) + sumOfDivisors(2) + sumOfDivisors(3) + sumOfDivisors(4) + sumOfDivisors(5) = 1 + 3 + 4 + 7 + 6 = 21.

public class SumOfDivisors {
    public static int sumOfAllDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * (n / i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumOfAllDivisors(n));
        // 21
    }
}
