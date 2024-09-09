// Count Digits - https://www.naukri.com/code360/problems/count-digits_8416387

// You are given a number ’n’.
// Find the number of digits of ‘n’ that evenly divide ‘n’.

// Note: A digit evenly divides ‘n’ if it leaves no remainder when dividing ‘n’.

// Input: ‘n’ = 336
// Output: 3
// Explanation: 336 is divisible by both ‘3’ and ‘6’. Since ‘3’ occurs twice it is counted two times.

public class CountDividingDigits {
    public static int countDigits(int n) {
        int num = n;
        int count = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            n /= 10;
            if (lastDigit != 0 && num % lastDigit == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 336;
        System.out.println(countDigits(n));
        // 3
    }
}
