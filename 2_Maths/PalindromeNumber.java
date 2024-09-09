// Palindrome Number - https://leetcode.com/problems/palindrome-number/description/

// Given an integer x, return true if x is a palindrome and false otherwise.

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int num = x;
        int rev = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            x /= 10;
            rev = rev * 10 + lastDigit;
        }
        return num == rev;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        // true
    }
}
