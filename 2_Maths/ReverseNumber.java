//  Reverse Integer - https://leetcode.com/problems/reverse-integer/

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// Input: x = 123
// Output: 321

// Input: x = -123
// Output: -321

public class ReverseNumber {
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            reverse = reverse * 10 + lastDigit;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(reverse(num));
        // 321
    }
}
